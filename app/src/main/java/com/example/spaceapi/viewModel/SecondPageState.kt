package com.example.spaceapi.viewModel

import com.example.spaceapi.model.SecondResponse

sealed class SecondPageState {
    object Loading: SecondPageState()
    data class Success(val data: SecondResponse): SecondPageState()
    data class Error(val message: String): SecondPageState()
}