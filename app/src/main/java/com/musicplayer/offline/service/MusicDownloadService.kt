package com.musicplayer.offline.service

import android.content.Context
import android.os.Environment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.File

class MusicDownloadService(private val context: Context) {

    private val downloadDir = File(
        context.getExternalFilesDir(Environment.DIRECTORY_MUSIC),
        "OfflineMusicPlayer"
    )

    init {
        if (!downloadDir.exists()) {
            downloadDir.mkdirs()
        }
    }

    suspend fun downloadMusicMP3(youtubeUrl: String, title: String): String? {
        return withContext(Dispatchers.IO) {
            try {
                val fileName = "${title.replace(" ", "_")}_128K.mp3"
                val outputFile = File(downloadDir, fileName)

                if (outputFile.exists()) {
                    Timber.d("Music already exists: ${outputFile.absolutePath}")
                    return@withContext outputFile.absolutePath
                }

                // yt-dlp command for MP3 128K download
                val command = arrayOf(
                    "yt-dlp",
                    "-f", "bestaudio",
                    "-x",
                    "--audio-format", "mp3",
                    "--audio-quality", "128K",
                    "-o", outputFile.absolutePath,
                    youtubeUrl
                )

                Timber.d("Starting download: $title")
                val process = Runtime.getRuntime().exec(command)
                val exitCode = process.waitFor()

                if (exitCode == 0 && outputFile.exists()) {
                    Timber.d("Download completed: ${outputFile.absolutePath}")
                    return@withContext outputFile.absolutePath
                } else {
                    Timber.e("Download failed with exit code: $exitCode")
                    return@withContext null
                }

            } catch (e: Exception) {
                Timber.e(e, "Error downloading music")
                return@withContext null
            }
        }
    }

    fun getDownloadedMusicFiles(): List<File> {
        return downloadDir.listFiles()?.filter { it.isFile && it.extension == "mp3" } ?: emptyList()
    }

    fun deleteMusicFile(filePath: String): Boolean {
        return try {
            File(filePath).delete()
        } catch (e: Exception) {
            Timber.e(e, "Error deleting file")
            false
        }
    }

    fun getMusicFileSize(filePath: String): Long {
        return try {
            File(filePath).length()
        } catch (e: Exception) {
            0L
        }
    }
}