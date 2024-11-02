package com.example.coremovie.data.repository

import com.example.coremovie.data.model.popular.PopularResponse

interface HomeRepository {
    suspend fun getPopularMovies(apiKey: String, language: String): Result<PopularResponse>
}