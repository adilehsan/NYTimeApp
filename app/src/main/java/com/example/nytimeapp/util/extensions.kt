package com.example.nytimeapp.util

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment


fun Fragment.showToast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
}