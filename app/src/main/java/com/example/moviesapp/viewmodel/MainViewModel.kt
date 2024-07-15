package com.example.moviesapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.datasource.RetrofitInstance
import com.example.moviesapp.data.model.Movie
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val apiService = RetrofitInstance.movieService
    private val _popularMovies = MutableStateFlow<List<Movie>>(emptyList())
    val popularMovies = _popularMovies.asStateFlow()
    fun getPopularMovies() {
        viewModelScope.launch(IO) {
            try {
                val response = apiService.getPopularMovies()
                _popularMovies.emit(response.results!!)
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching popular movies", e)
            }
        }
    }
}