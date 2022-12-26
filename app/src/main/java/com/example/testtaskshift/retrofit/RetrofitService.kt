package com.example.testtaskshift.retrofit

import com.example.testtaskshift.data.entity.CardInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("{bin}")
    fun getCardInformation(
        @Path("bin") bin : String
    ): Call<CardInfo>
}