package com.example.testtaskshift.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testtaskshift.data.dao.BankDao
import com.example.testtaskshift.data.dao.CardInfoDao
import com.example.testtaskshift.data.dao.CardNumberDao
import com.example.testtaskshift.data.dao.CountryDao
import com.example.testtaskshift.data.entity.Bank
import com.example.testtaskshift.data.entity.CardInfo
import com.example.testtaskshift.data.entity.CardNumber
import com.example.testtaskshift.data.entity.Country

@Database(entities = [CardInfo::class,  Bank::class, CardNumber::class, Country::class], version = 8)
abstract class AppDatabase : RoomDatabase(){
    abstract fun getCardInfoDao() : CardInfoDao
    abstract fun getBankDao() : BankDao
    abstract fun getCardNumberDao() : CardNumberDao
    abstract fun getCountryDao() : CountryDao
}