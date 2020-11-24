package com.example.roombottomnavigation.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roombottomnavigation.room.Group

@Dao
interface DaoGroup {

    @Query("SELECT * FROM `group_table`")
    fun getAllGroup(): List<Group>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllGroup(group: List<Group>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGroup(group: Group)

    @Query("DELETE  FROM `group_table`")
    fun deleteAllGroup()
}