package com.example.nytimeapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.nytimeapp.R
import com.example.nytimeapp.network.ApiHelper
import com.example.nytimeapp.network.RetrofitBuilder
import com.example.nytimeapp.viewModel.MainApiViewModel
import com.example.nytimeapp.viewModel.ViewModelFactoryUM
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}