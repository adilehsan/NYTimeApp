package com.example.nytimeapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nytimeapp.network.ApiHelper
import com.example.nytimeapp.network.ApiRepository

class ViewModelFactoryUM(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainApiViewModel(ApiRepository(apiHelper)) as T
    }

}