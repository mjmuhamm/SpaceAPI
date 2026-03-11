package com.example.spaceapi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaceapi.repository.SecondPageRepository
import kotlinx.coroutines.launch

class SecondPageViewModel(private val repository: SecondPageRepository = SecondPageRepository()) : ViewModel() {

    private val _secondState = MutableLiveData< SecondPageState>(SecondPageState.Loading)
    val secondState = _secondState


    fun secondPage(id: String) {
        viewModelScope.launch {
            _secondState.value = SecondPageState.Loading
            val result = repository.getSecondPageInfo(id)
            _secondState.value = if (result.isSuccess) {
                val info = result.getOrNull()
                if (info != null) {
                    SecondPageState.Success(info)  // pass the actual response
                } else {
                    SecondPageState.Error(result.exceptionOrNull()?.message ?: "Unknown Error")
                }
            } else {
                SecondPageState.Error(result.exceptionOrNull()?.message ?: "Unknown Error")
            }
        }
    }
}