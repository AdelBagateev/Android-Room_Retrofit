package com.example.testtaskshift.retrofit

import com.example.shakil.kotlinjsonexample.Retrofit.RetrofitClient


object Common {

    private val BASE_URL = "https://lookup.binlist.net/"
    val retrofitService: RetrofitService
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}