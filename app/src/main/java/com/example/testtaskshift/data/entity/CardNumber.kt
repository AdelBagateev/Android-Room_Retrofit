package com.example.testtaskshift.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName =  "card_number")
data class CardNumber (
    @PrimaryKey(autoGenerate = true)
    var id :Int,
    var bin : String?=null,
    val length: Int? = null,
    val luhn: Boolean? = null,
)
