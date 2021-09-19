package com.example.nytimeapp.network

class ApiHelper(private val apiService: ApiService) {
    suspend fun getArticles() = apiService.getData()
}