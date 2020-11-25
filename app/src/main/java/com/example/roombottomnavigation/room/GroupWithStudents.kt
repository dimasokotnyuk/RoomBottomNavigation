package com.example.roombottomnavigation.room

import androidx.room.Embedded
import androidx.room.Relation

data class GroupWithStudents(
    @Embedded val group: Group,
    @Relation(
        parentColumn = "id",
        entityColumn = "groupId"
    )
    val student: List<Student>
)