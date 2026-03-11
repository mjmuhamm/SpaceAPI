package com.example.spaceapi.api

import com.example.spaceapi.model.SecondResponse
import com.example.spaceapi.model.SpaceResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpaceApi {
    @GET("articles")
    suspend fun getInfo(@Query("format") format: String = "json") : SpaceResponse
}






