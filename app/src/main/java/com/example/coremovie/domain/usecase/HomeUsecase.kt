package com.example.coremovie.domain.usecase

import com.example.coremovie.domain.model.popular.PopularResponse


interface HomeUsecase {
    suspend fun fetchPopularMovies(apiKey: String, language: String): Result<PopularResponse>
}