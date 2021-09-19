package com.example.nytimeapp.dao.response

import com.google.gson.annotations.SerializedName

data class ArticleResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("results")
    val results: List<ArticleResultModel>? = null
)
