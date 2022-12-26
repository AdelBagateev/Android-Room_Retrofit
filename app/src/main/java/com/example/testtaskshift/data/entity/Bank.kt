package com.example.testtaskshift.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bank")
data class Bank (
    @PrimaryKey(autoGenerate = true)
    var id :Int,
    val name: String? = null,
    val url: String? = null,
    val phone: String? = null,
    val city: String? = null,
)
