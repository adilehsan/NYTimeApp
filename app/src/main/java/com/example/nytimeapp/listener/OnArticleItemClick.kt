package com.example.nytimeapp.listener

import com.example.nytimeapp.dao.response.ArticleResultModel

interface OnArticleItemClick {
    fun onItemClick(resultModel: ArticleResultModel)
}