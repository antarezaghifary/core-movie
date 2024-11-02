package com.example.coremovie.data.datasource

import com.example.coremovie.data.model.popular.PopularResponse
import com.example.coremovie.data.remote.api.ApiService
import com.example.coremovie.data.repository.HomeRepository

class HomeDataSource(
    private val api: ApiService
) : HomeRepository {
    //code
    override suspend fun getPopularMovies(
        apiKey: String,
        language: String
    ): Result<PopularResponse> {
        return try {
            // Make the API call
            val response = api.getDataPopular(apiKey, language)

            // Check if the response is successful
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.success(it) // Return successful result with data
                } ?: Result.failure(Exception("Empty response body"))
            } else {
                Result.failure(Exception("Error: ${response.code()} - ${response.message()}"))
            }
        } catch (e: Exception) {
            // Handle exceptions (like network errors)
            Result.failure(e)
        }
    }
}