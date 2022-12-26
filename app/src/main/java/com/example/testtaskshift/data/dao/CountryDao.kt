package com.example.testtaskshift.data.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testtaskshift.data.entity.CardInfo
import com.example.testtaskshift.data.entity.CardNumber
import com.example.testtaskshift.data.entity.Country

@Dao
interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(country: Country)

    @Query("SELECT * FROM country WHERE id = :id")
    suspend fun getById(id : Int) : Country

}