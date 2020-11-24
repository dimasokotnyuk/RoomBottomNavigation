package com.example.roombottomnavigation.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "faculty_table")
data class Faculty(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    var nameFaculty: String,
    var group: String,
    var university: String
    )