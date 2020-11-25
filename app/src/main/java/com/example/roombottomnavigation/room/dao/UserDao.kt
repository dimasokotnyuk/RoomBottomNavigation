package com.example.roombottomnavigation.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roombottomnavigation.room.Group
import com.example.roombottomnavigation.room.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)
}