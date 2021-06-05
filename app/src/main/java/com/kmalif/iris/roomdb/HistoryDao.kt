package com.kmalif.iris.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kmalif.iris.models.History

@Dao
interface HistoryDao {

    @Insert
    suspend fun addHistory(history: History)

    @Delete
    suspend fun deleteHistory(history: History)

    @Query("SELECT * FROM ")
    suspend fun getHistory(): List<History>

}