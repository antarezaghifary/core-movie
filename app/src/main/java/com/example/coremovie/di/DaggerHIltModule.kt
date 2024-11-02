package com.example.coremovie.di

import com.example.coremovie.data.datasource.HomeDataSource
import com.example.coremovie.data.remote.api.ApiService
import com.example.coremovie.data.repository.HomeRepository
import com.example.coremovie.domain.interactor.HomeInteractor
import com.example.coremovie.domain.usecase.HomeUsecase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MyModule {

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        // Create and return your ApiService instance (e.g., using Retrofit)
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideHomeDataSource(apiService: ApiService): HomeDataSource {
        return HomeDataSource(apiService)
    }

    @Provides
    fun provideGetItemsUseCase(repository: HomeRepository): HomeUsecase {
        return HomeInteractor(repository)
    }

    // Provide other dependencies
}