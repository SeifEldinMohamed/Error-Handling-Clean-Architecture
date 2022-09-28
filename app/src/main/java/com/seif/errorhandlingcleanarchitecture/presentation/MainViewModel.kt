package com.seif.errorhandlingcleanarchitecture.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seif.errorhandlingcleanarchitecture.domain.usecase.SubmitEmailUseCase
import com.seif.errorhandlingcleanarchitecture.util.Resource
import kotlinx.coroutines.launch

class MainViewModel(
    private val submitEmailUseCase: SubmitEmailUseCase = SubmitEmailUseCase()
) : ViewModel() {
    var email by mutableStateOf("")
        private set
    var error by mutableStateOf<String?>(null)
        private set

    fun onEmailChanged(email: String) {
        this.email = email
    }

    fun submitEmail() {
        viewModelScope.launch {
            val result = submitEmailUseCase(email)
            when (result) {
                is Resource.Success -> {

                }
                is Resource.Error -> {
                    error = result.message
                }
            }
        }
    }

}