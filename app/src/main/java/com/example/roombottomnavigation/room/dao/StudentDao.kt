package com.example.roombottomnavigation.room.dao

import android.util.Log
import androidx.room.*
import com.example.roombottomnavigation.room.GroupWithStudents
import com.example.roombottomnavigation.room.Student
import com.example.roombottomnavigation.room.StudentWithGroup

@Dao
interface StudentDao {

    @Query("SELECT * FROM student_table")
    fun getAllStudents(): List<Student>

    @Query("SELECT * FROM student_table")
    fun getAllStudentsWithGroups(): List<StudentWithGroup>

    @Query("UPDATE student_table SET firstName =:newName WHERE id=:newId")
    fun updateName(newName: String, newId: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllStudents(students: List<Student>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudent(student: Student)

    @Update
    fun updateStudent(student: Student) {
        throw UnsupportedOperationException()
    }

    @Delete
    fun deleteStudent(student: Student)

    @Query("DELETE  FROM student_table")
    fun deleteAllStudents()

    @Transaction
    fun makeTransaction(student: Student) {
        insertStudent(student)
        updateStudent(student)
    }
}