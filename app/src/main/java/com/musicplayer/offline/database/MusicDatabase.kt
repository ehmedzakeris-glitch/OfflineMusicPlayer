package com.musicplayer.offline.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.musicplayer.offline.model.Music

@Database(entities = [Music::class], version = 1)
abstract class MusicDatabase : RoomDatabase() {
    abstract fun musicDao(): MusicDao
}