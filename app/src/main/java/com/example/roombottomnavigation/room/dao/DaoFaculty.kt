package com.example.roombottomnavigation.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roombottomnavigation.room.Faculty

@Dao
interface DaoFaculty {

    @Query("SELECT * FROM `faculty_table`")
    fun getAllFaculty(): List<Faculty>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllFaculty(faculty: List<Faculty>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFaculty(faculty: Faculty)

    @Query("DELETE  FROM `faculty_table`")
    fun deleteAllFaculty()
}