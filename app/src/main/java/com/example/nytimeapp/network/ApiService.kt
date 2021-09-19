package com.example.nytimeapp.network

import com.example.nytimeapp.dao.response.ArticleResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=lrGPtdbM8FJRV5LoNjQ1u1lFgfPLdTnl")
    suspend fun getData(): Response<ArticleResponse>
}