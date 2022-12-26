package com.example.testtaskshift.data.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testtaskshift.data.entity.CardNumber

@Dao
interface CardNumberDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(cardNumber: CardNumber)

    @Query("SELECT * FROM card_number WHERE id = :id")
    suspend  fun getById(id : Int) : CardNumber
}