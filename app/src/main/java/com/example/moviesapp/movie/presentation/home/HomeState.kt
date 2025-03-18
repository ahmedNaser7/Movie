package com.example.moviesapp.movie.presentation.home

import com.example.moviesapp.core.domain.model.movie.Movie

data class HomeState(
    val lastMovie: Movie = Movie(),
    val recommendedMovies: List<Movie> = emptyList(),
    val releasesMovies: List<Movie> = emptyList(),
    val isSuccess: Boolean = false,
    val error: String = "",
    val isLoading: Boolean = false,
)

