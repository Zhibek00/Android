package com.example.project

import android.content.ClipData
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Tours::class], version = 1)
abstract class MainDb:RoomDatabase() {
    abstract fun getDao():Dao
    companion object{
        fun getDb(context: Context):MainDb{
            return Room.databaseBuilder(
                context.applicationContext,
                MainDb::class.java,
                "tours_main_database0.db"
            ).createFromAsset("database/tours.db").build()
        }
    }
}