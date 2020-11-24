package com.example.roombottomnavigation.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "university_table")
data class University(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    var nameUniversity: String,
    var faculty: String,
    val group: String,
)