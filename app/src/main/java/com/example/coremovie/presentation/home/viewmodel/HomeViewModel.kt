package com.example.coremovie.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coremovie.domain.interactor.HomeInteractor
import kotlinx.coroutines.launch

class HomeViewModel(
    private val homeInteractor: HomeInteractor
) : ViewModel(){
    fun getPopularMovies(apiKey: String, language: String) {
        viewModelScope.launch {
            val result = homeInteractor.fetchPopularMovies(apiKey, language)
            result.onSuccess { popularResponse ->
                // Handle the successful response (update UI, etc.)
            }.onFailure { exception ->
                // Handle the error (show error message, etc.)
            }
        }
    }

}