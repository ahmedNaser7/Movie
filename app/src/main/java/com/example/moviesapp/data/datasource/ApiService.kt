package com.example.moviesapp.data.datasource

import com.example.moviesapp.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ApiService {
    @GET("movie/popular?language=en-US&page=1")
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiOTFiZmJjYWZhMjgyMmNlMmZlNWUwYzJmNzVmNGUzOCIsIm5iZiI6MTcyMDQ0NDMxOS45MzcxNzgsInN1YiI6IjY2ODkzMzJjN2M0MmZjMTA3MjllZGY3MyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.9IFGousfc_G-F8eewOmrv3ehTOh4LumXn4QKtUorOqQ")
    suspend fun getPopularMovies(): MovieResponse
}