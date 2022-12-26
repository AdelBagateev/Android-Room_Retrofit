package com.example.testtaskshift.data.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.testtaskshift.data.entity.CardInfo

@Dao
interface CardInfoDao {
    @Insert(onConflict = REPLACE)
    suspend fun save(cardInfo: CardInfo)

    @Query("SELECT * FROM card_info WHERE id = :id")
    suspend fun getById(id : Int) : CardInfo

    @Query("SELECT * FROM card_info")
    suspend fun getAll() : List<CardInfo>

}