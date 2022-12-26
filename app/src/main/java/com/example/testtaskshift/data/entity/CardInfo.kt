package com.example.testtaskshift.data.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.lang.reflect.Constructor

@Entity(tableName = "card_info")
data class CardInfo(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @Ignore
    var number: CardNumber? = null,
    val scheme: String? = null,
    val type: String? = null,
    val brand: String? = null,
    val prepaid: Boolean? = null,
    @Ignore
    var country: Country? = null,
    @Ignore
    var bank: Bank? = null
)
    {
    constructor(id: Int, scheme: String?, type: String?, brand: String?, prepaid: Boolean?) : this(
        id,
        null,
        scheme,
        type,
        brand,
        prepaid,
        null,
        null
    )
}