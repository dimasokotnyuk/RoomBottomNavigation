package com.example.roombottomnavigation.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "group_table")
data class Group(
    @PrimaryKey val id: Int,
    var nameGroup: String,
    var faculty: String,
    var univeristy: String
)