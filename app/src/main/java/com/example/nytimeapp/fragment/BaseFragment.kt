package com.example.nytimeapp.fragment

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.nytimeapp.network.ApiHelper
import com.example.nytimeapp.network.RetrofitBuilder
import com.example.nytimeapp.util.CustomProgressBar
import com.example.nytimeapp.viewModel.MainApiViewModel
import com.example.nytimeapp.viewModel.ViewModelFactoryUM

open class BaseFragment :  Fragment(){

    fun getViewModel(): ViewModel {
        return ViewModelProviders.of(
            this,
            ViewModelFactoryUM(ApiHelper(RetrofitBuilder.API_SERVICE))
        ).get(MainApiViewModel::class.java)
    }

    private var progressBar: CustomProgressBar? = null
    fun showLoading(it: Boolean) {
        activity?.let { act ->
            try {
                if (it) {
                    if (progressBar?.dialog != null) {
                        when (progressBar?.dialog?.isShowing) {
                            false -> {
                                progressBar?.show(act, "Please Wait...")
                            }
                            else -> progressBar?.dialog?.dismiss()
                        }
                    } else {
                        progressBar = CustomProgressBar()
                        progressBar?.show(act, "Please Wait...")
                    }
                } else {
                    if (progressBar?.dialog != null) {
                        progressBar?.dialog?.dismiss()
                    } else {

                    }
                }
            } catch (ex: IllegalStateException) {
                ex.printStackTrace()
            }

        }
    }
}