package com.example.coremovie.domain.interactor

import com.example.coremovie.data.repository.HomeRepository
import com.example.coremovie.domain.model.popular.PopularResponse
import com.example.coremovie.domain.model.popular.toDomain
import com.example.coremovie.domain.usecase.HomeUsecase
import com.example.coremovie.util.ERROR
import com.example.coremovie.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flatMap
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HomeInteractor @Inject constructor(
    private val repo: HomeRepository
) : HomeUsecase {
    override suspend fun fetchPopularMovies(): Flow<Resource<PopularResponse>> {
        return flow {
            emit(Resource.Loading())
            try {
                repo.getPopularMovies().collect { dataResponse ->
                    emit(Resource.Success(dataResponse.data?.toDomain()))
                }
            } catch (e: Exception) {
                emit(Resource.Error(error = ERROR.General, errMsg = "Failed to fetch popular movies: ${e.message}"))
            }
        }
    }
}
