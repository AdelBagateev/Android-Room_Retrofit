package com.example.testtaskshift.data.entity

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
data class Country (
    @PrimaryKey(autoGenerate = true)
    var id :Int,
    val numeric: String? = null,
    val alpha2: String? = null,
    val name: String? = null,
    val emoji: String? = null,
    val currency: String? = null,
    val latitude: Int? = null,
    val longitude: Int? = null,
)
