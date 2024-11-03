package com.example.coremovie.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coremovie.domain.interactor.HomeInteractor
import com.example.coremovie.domain.model.popular.PopularResponse
import com.example.coremovie.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel(
    private val homeInteractor: HomeInteractor
) : ViewModel() {

    private val _popularMoviesState = MutableLiveData<Resource<PopularResponse>>()
    val popularMoviesState: LiveData<Resource<PopularResponse>> = _popularMoviesState
    fun getPopularMovies() {
        viewModelScope.launch {
            homeInteractor.fetchPopularMovies().collect { result ->
                _popularMoviesState.value = result
            }
        }
    }
}