package com.example.testtaskshift.data

import com.example.testtaskshift.data.entity.CardInfo


object LocalCardInfoRepository {
    var cardsInfo:List<CardInfo> = arrayListOf()

    fun  updateRepository(list:List<CardInfo>) {
        cardsInfo = list
    }
}