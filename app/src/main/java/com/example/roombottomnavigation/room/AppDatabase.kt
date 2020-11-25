package com.example.roombottomnavigation.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roombottomnavigation.room.dao.*

@Database(
    entities = [Student::class, Faculty::class, Group::class, University::class, User::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
    abstract fun groupDao(): DaoGroup
    abstract fun facultyDao(): DaoFaculty
    abstract fun universityDao(): DaoUniversity
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDataBase(context: Context?): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    if (context != null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            "myDB"
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}