package com.musicplayer.offline.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "music")
data class Music(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val artist: String,
    val youtubeUrl: String,
    val filePath: String,
    val fileName: String,
    val fileSize: Long,
    val duration: Long,
    val downloadedDate: Long = System.currentTimeMillis(),
    val thumbnail: String? = null
)