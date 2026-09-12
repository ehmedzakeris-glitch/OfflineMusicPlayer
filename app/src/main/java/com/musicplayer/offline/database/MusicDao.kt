package com.musicplayer.offline.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.musicplayer.offline.model.Music
import kotlinx.coroutines.flow.Flow

@Dao
interface MusicDao {
    @Insert
    suspend fun insertMusic(music: Music)

    @Delete
    suspend fun deleteMusic(music: Music)

    @Query("SELECT * FROM music ORDER BY downloadedDate DESC")
    fun getAllMusic(): Flow<List<Music>>

    @Query("SELECT * FROM music WHERE id = :musicId")
    suspend fun getMusicById(musicId: Int): Music?

    @Query("DELETE FROM music WHERE id = :musicId")
    suspend fun deleteMusicById(musicId: Int)
}