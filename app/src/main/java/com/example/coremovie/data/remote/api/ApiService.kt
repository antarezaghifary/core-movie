package com.example.coremovie.data.remote.api

import com.example.coremovie.data.model.popular.PopularResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getDataPopular(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Response<PopularResponse>
}