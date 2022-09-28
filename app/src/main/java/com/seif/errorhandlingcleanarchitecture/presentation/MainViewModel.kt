package com.seif.errorhandlingcleanarchitecture.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var email by mutableStateOf("")
    private var error by mutableStateOf<String?>(null)

    fun onEmailChanged(email:String) {
        this.email = email
    }

}