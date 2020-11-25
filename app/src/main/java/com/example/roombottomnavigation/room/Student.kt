package com.example.roombottomnavigation.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    var firstName: String?,
    var lastName: String?,
    var groupId: Int?,
    var faculty: String?,
    var university: String?
)