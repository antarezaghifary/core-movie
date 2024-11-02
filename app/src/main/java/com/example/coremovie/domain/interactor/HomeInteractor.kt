package com.example.coremovie.domain.interactor

import com.example.coremovie.data.repository.HomeRepository
import com.example.coremovie.domain.model.popular.PopularResponse
import com.example.coremovie.domain.model.popular.toDomain
import com.example.coremovie.domain.usecase.HomeUsecase

class HomeInteractor(
    private val repo: HomeRepository
) : HomeUsecase {
    override suspend fun fetchPopularMovies(
        apiKey: String,
        language: String
    ): Result<PopularResponse> {
        return repo.getPopularMovies(apiKey, language).map { dataResponse ->
            dataResponse.toDomain()
        }
    }
}
