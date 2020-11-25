package com.example.roombottomnavigation.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roombottomnavigation.room.Group
import com.example.roombottomnavigation.room.GroupWithStudents

@Dao
interface DaoGroup {

    @Query("SELECT * FROM `group_table`")
    fun getAllGroup(): List<Group>


    @Query("SELECT * FROM `group_table` WHERE id=:groupId ")
    fun getGroupWithStudents(groupId: Int): GroupWithStudents

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllGroup(group: List<Group>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGroup(group: Group)

    @Query("DELETE  FROM `group_table`")
    fun deleteAllGroup()
}