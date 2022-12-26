package com.example.testtaskshift.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testtaskshift.data.entity.Bank
import com.example.testtaskshift.data.entity.CardInfo

@Dao
interface BankDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(bank: Bank)

    @Query("SELECT * FROM bank WHERE id = :id")
    suspend  fun getById(id : Int) : Bank

}