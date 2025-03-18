package com.example.moviesapp.movie.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.core.domain.datasource.HomeDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class HomeViewModel(
    private val homeDataSource: HomeDataSource
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()
        .onStart {
            getTheNewRecommendedMovie()
            getRecommendedMovies()
            getReleasesMovies()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(4000),
            HomeState()
        )

    private fun getTheNewRecommendedMovie() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            try {
                val movie = homeDataSource.getLastMovie().results!![0]
                _state.update { it.copy(lastMovie = movie, isSuccess = true, isLoading = false) }
            } catch (e: Exception) {
                _state.update { it.copy(error = e.message.toString(), isLoading = false) }
            }
        }
    }

    private fun getRecommendedMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            try {
                val movies = homeDataSource.getRecommendedMovies().results!!
                _state.update {
                    it.copy(
                        recommendedMovies = movies,
                        isSuccess = true,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _state.update { it.copy(error = e.message.toString(), isLoading = false) }
            }
        }
    }

    private fun getReleasesMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            try {
                val movies = homeDataSource.getNewReleasesMovies().results!!
                _state.update {
                    it.copy(
                        releasesMovies = movies,
                        isSuccess = true,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _state.update { it.copy(error = e.message.toString(), isLoading = false) }
            }
        }
    }
}