package com.musicplayer.offline.service

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import timber.log.Timber

class MusicPlayerService(context: Context) {

    private val exoPlayer: ExoPlayer = ExoPlayer.Builder(context).build()

    fun playMusic(filePath: String) {
        try {
            val mediaItem = MediaItem.fromUri(filePath)
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
            exoPlayer.play()
            Timber.d("Playing music: $filePath")
        } catch (e: Exception) {
            Timber.e(e, "Error playing music")
        }
    }

    fun pauseMusic() {
        exoPlayer.pause()
        Timber.d("Music paused")
    }

    fun resumeMusic() {
        exoPlayer.play()
        Timber.d("Music resumed")
    }

    fun stopMusic() {
        exoPlayer.stop()
        exoPlayer.clearMediaItems()
        Timber.d("Music stopped")
    }

    fun getCurrentPosition(): Long = exoPlayer.currentPosition

    fun getDuration(): Long = exoPlayer.duration

    fun isPlaying(): Boolean = exoPlayer.isPlaying

    fun setPlaybackSpeed(speed: Float) {
        exoPlayer.setPlaybackSpeed(speed)
        Timber.d("Playback speed: $speed")
    }

    fun release() {
        exoPlayer.release()
        Timber.d("Player released")
    }
}