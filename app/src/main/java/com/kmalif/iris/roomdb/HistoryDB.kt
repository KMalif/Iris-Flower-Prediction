package com.kmalif.iris.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kmalif.iris.models.History

@Database(
    //entities adalah data class atau table yang menyimpan data
    entities = [History::class],
    version = 1
)
abstract class HistoryDB : RoomDatabase(){

    abstract fun historyDao() : HistoryDao

    companion object {

        @Volatile private var instance : HistoryDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            HistoryDB::class.java,
            "prediction_history.db"
        ).build()

    }
}