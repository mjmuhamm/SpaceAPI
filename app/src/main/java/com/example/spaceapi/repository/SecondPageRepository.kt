package com.example.spaceapi.repository

import com.example.spaceapi.api.SecondPageApi
import com.example.spaceapi.remote.SecondPageRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SecondPageRepository(private var api: SecondPageApi = SecondPageRetrofitClient.api) {

    suspend fun getSecondPageInfo(id: String): Result<com.example.spaceapi.model.SecondResponse> = withContext(Dispatchers.IO) {
        try {
            val info = api.getInfo(id)
            Result.success(info)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}