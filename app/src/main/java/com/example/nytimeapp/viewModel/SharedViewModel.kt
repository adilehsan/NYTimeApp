package com.example.nytimeapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.nytimeapp.dao.response.ArticleResultModel
import com.example.nytimeapp.network.ApiRepository
import com.example.nytimeapp.network.Resource
import kotlinx.coroutines.Dispatchers

class SharedViewModel: ViewModel() {
    private val arrArticles: ArrayList<ArticleResultModel> = ArrayList()
    var publishDate = MutableLiveData<String>()
    var title = MutableLiveData<String>()
    var byLine = MutableLiveData<String>()
    var abstract = MutableLiveData<String>()
    var source = MutableLiveData<String>()

    fun setArticles(dealOfTheDay: List<ArticleResultModel>?) {
        dealOfTheDay?.let {
            this.arrArticles.clear()
            this.arrArticles.addAll(it)
        }
    }

    fun getArticles(): ArrayList<ArticleResultModel> {
        return arrArticles
    }
}