package com.example.roombottomnavigation.room.dao

import androidx.room.*
import com.example.roombottomnavigation.room.Student

@Dao
interface StudentDao {

    @Query("SELECT * FROM student_table")
    fun getAllStudents(): List<Student>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllStudents(students: List<Student>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudent(student: Student)

    @Delete
    fun deleteStudent(student: Student)

    @Query("DELETE  FROM student_table")
    fun deleteAllStudents()
}