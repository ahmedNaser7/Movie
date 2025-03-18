package com.example.moviesapp.core.domain.datasource

import com.example.moviesapp.core.domain.model.movie.MovieResponse

interface HomeDataSource {
    suspend fun getLastMovie(): MovieResponse
    suspend fun getNewReleasesMovies(): MovieResponse
    suspend fun getRecommendedMovies(): MovieResponse
}