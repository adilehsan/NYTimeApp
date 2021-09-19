package com.example.nytimeapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {
    private val BASE_URL = "http://api.nytimes.com/"

    /**
     * Create an instance of Retrofit object
     */
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val API_SERVICE : ApiService = getRetrofit().create(ApiService::class.java)
}