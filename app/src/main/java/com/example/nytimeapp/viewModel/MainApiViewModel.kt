package com.example.nytimeapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.nytimeapp.network.ApiRepository
import com.example.nytimeapp.network.Resource
import kotlinx.coroutines.Dispatchers

class MainApiViewModel(private val apiRepository: ApiRepository) : ViewModel() {
    fun getArticleList() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = apiRepository.getArticles()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}