package com.example.roombottomnavigation.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roombottomnavigation.room.University

@Dao
interface DaoUniversity{

        @Query("SELECT * FROM `university_table`")
        fun getAllUniversity(): List<University>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertAllUniversity(university: List<University>)

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertUniversity(university: University)

        @Query("DELETE  FROM `university_table`")
        fun deleteAllUniversity()
}