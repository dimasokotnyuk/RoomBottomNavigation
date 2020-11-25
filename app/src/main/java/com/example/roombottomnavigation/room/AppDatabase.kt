package com.example.roombottomnavigation.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roombottomnavigation.room.dao.DaoFaculty
import com.example.roombottomnavigation.room.dao.DaoGroup
import com.example.roombottomnavigation.room.dao.DaoUniversity
import com.example.roombottomnavigation.room.dao.StudentDao

@Database(entities = [Student::class,Faculty::class,Group::class,University::class], version = 5, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
    abstract fun groupDao(): DaoGroup
    abstract fun facultyDao(): DaoFaculty
    abstract fun universityDao(): DaoUniversity

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "myDB"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}