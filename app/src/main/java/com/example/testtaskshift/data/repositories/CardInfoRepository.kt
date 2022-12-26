package com.example.testtaskshift.data.repositories

import android.content.Context
import androidx.room.Room
import com.example.testtaskshift.data.AppDatabase
import com.example.testtaskshift.data.entity.Bank
import com.example.testtaskshift.data.entity.CardInfo
import com.example.testtaskshift.data.entity.CardNumber
import com.example.testtaskshift.data.entity.Country

class CardInfoRepository(context: Context) {
    private val db by lazy{
        Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
            .build()
    }
    private val bankDao by lazy {
        db.getBankDao()
    }
    private val cardInfoDao by lazy {
        db.getCardInfoDao()
    }
    private val cardNumberDao by lazy {
        db.getCardNumberDao()
    }
    private val countryDao by lazy {
        db.getCountryDao()
    }




    suspend fun saveCardInfo(cardInfo: CardInfo) {
        cardInfoDao.save(cardInfo)
    }

    suspend fun getAllCardsInfo() :  List<CardInfo> {
        return cardInfoDao.getAll()
    }


    suspend fun saveBank(bank: Bank) {
        bankDao.save(bank)
    }

    suspend fun getBankById(id: Int) : Bank{
        return  bankDao.getById(id)
    }


    suspend fun saveCountry(country: Country) {
        countryDao.save(country)
    }

    suspend fun getCountryById(id: Int) :Country{
        return countryDao.getById(id)
    }


    suspend fun saveCardNumber(cardNumber: CardNumber){
        cardNumberDao.save(cardNumber)
    }

    suspend fun getCardNumberById(id: Int) :CardNumber{
        return cardNumberDao.getById(id)
    }


    companion object {
        private const val  DATABASE_NAME = "card.db"
    }

}