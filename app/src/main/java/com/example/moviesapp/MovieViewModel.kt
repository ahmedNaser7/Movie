package com.example.moviesapp

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.core.data.network.RetrofitInstance
import com.example.moviesapp.core.domain.model.movie.Movie
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val apiService = RetrofitInstance.movieService


    private val _movie = MutableStateFlow(Movie())
    val movie = _movie.asStateFlow()

    var similarMovies by mutableStateOf(listOf(Movie()))
        private set

    var searchedMovies by mutableStateOf(listOf(Movie()))
        private set

    var categoryMovies by mutableStateOf(listOf(Movie()))
        private set


    fun getMovieDetails(movieId: String) {
        viewModelScope.launch(IO) {
            try {
                val response = apiService.getMovieDetails(movieId.toInt())
                _movie.emit(response)
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching popular movies", e)
            }
        }

    }

    fun getSimilarMovies(movieId: String) {
        viewModelScope.launch(IO) {
            try {
                val response = apiService.getSimilarMovies(movieId.toInt())
                similarMovies = response.results!!
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching popular movies", e)
            }
        }
    }

    fun getSearchingMovies(query: String) {
        viewModelScope.launch(IO) {
            try {
                val response = apiService.getMoviesBySearch(query)
                searchedMovies = response.results!!
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching popular movies", e)
            }
        }
    }


    fun getMoviesByCate(cate: String) {
        viewModelScope.launch(IO) {
            try {
                val response = apiService.getMoviesByCategory(cate)
                categoryMovies = response.results!!
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching popular movies", e)
            }
        }
    }


}