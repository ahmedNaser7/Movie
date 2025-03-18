package com.example.moviesapp.core.data.datasource

import com.example.moviesapp.core.data.network.MovieService
import com.example.moviesapp.core.domain.datasource.HomeDataSource
import com.example.moviesapp.core.domain.model.movie.MovieResponse

class HomeDataSourceImpl(
   private val movieService: MovieService
): HomeDataSource {
    override suspend fun getLastMovie(): MovieResponse {
      return movieService.getLastMovie()
    }

    override suspend fun getNewReleasesMovies(): MovieResponse {
        return movieService.getReleasesMovies()
    }

    override suspend fun getRecommendedMovies(): MovieResponse {
        return movieService.getPopularMovies("1")
    }
}