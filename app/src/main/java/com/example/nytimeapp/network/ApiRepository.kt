package com.example.nytimeapp.network

import com.example.nytimeapp.dao.response.ArticleResponse
import com.example.nytimeapp.listener.RepoResponseListener

class ApiRepository(val apiHelper: ApiHelper) {
   suspend fun getArticles() = apiHelper.getArticles()
}