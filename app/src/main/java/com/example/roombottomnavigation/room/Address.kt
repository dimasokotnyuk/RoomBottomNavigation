package com.example.roombottomnavigation.room

import androidx.room.ColumnInfo

data class Address(
    val street: String?,
    val state: String?,
    val city: String?,
    @ColumnInfo(name = "post_code") val postCode: Int
)