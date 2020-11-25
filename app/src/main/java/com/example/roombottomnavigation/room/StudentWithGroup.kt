package com.example.roombottomnavigation.room

import androidx.room.Embedded
import androidx.room.Relation

data class StudentWithGroup(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "groupId",
        entityColumn = "id"
    )
    val group: Group
)