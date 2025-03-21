package com.example.moviesapp.core.data.network

import com.example.moviesapp.core.domain.model.category.CategoryResponse
import com.example.moviesapp.core.domain.model.movie.Movie
import com.example.moviesapp.core.domain.model.movie.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieService {

    // Home Screen
    @GET("movie/upcoming?language=en-US&page=1")
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiOTFiZmJjYWZhMjgyMmNlMmZlNWUwYzJmNzVmNGUzOCIsIm5iZiI6MTcyMDQ0NDMxOS45MzcxNzgsInN1YiI6IjY2ODkzMzJjN2M0MmZjMTA3MjllZGY3MyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.9IFGousfc_G-F8eewOmrv3ehTOh4LumXn4QKtUorOqQ")
    suspend fun getLastMovie(): MovieResponse

    @GET("movie/popular?language=en-US")
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiOTFiZmJjYWZhMjgyMmNlMmZlNWUwYzJmNzVmNGUzOCIsIm5iZiI6MTcyMDQ0NDMxOS45MzcxNzgsInN1YiI6IjY2ODkzMzJjN2M0MmZjMTA3MjllZGY3MyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.9IFGousfc_G-F8eewOmrv3ehTOh4LumXn4QKtUorOqQ")
    suspend fun getPopularMovies(@Query("page") page: String): MovieResponse

    @GET("trending/movie/day?language=en-US")
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiOTFiZmJjYWZhMjgyMmNlMmZlNWUwYzJmNzVmNGUzOCIsIm5iZiI6MTcyMDQ0NDMxOS45MzcxNzgsInN1YiI6IjY2ODkzMzJjN2M0MmZjMTA3MjllZGY3MyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.9IFGousfc_G-F8eewOmrv3ehTOh4LumXn4QKtUorOqQ")
    suspend fun getReleasesMovies(): MovieResponse

    @GET("movie/{movie_id}?language=en-US")
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiOTFiZmJjYWZhMjgyMmNlMmZlNWUwYzJmNzVmNGUzOCIsIm5iZiI6MTcyMDQ0NDMxOS45MzcxNzgsInN1YiI6IjY2ODkzMzJjN2M0MmZjMTA3MjllZGY3MyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.9IFGousfc_G-F8eewOmrv3ehTOh4LumXn4QKtUorOqQ")
    suspend fun getMovieDetails(@Path("movie_id") movieId: Int): Movie

    @GET("movie/{movie_id}/similar?language=en-US&page=1")
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiOTFiZmJjYWZhMjgyMmNlMmZlNWUwYzJmNzVmNGUzOCIsIm5iZiI6MTcyMDQ0NDMxOS45MzcxNzgsInN1YiI6IjY2ODkzMzJjN2M0MmZjMTA3MjllZGY3MyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.9IFGousfc_G-F8eewOmrv3ehTOh4LumXn4QKtUorOqQ")
    suspend fun getSimilarMovies(@Path("movie_id") movieId: Int): MovieResponse

    @GET("search/collection?include_adult=false&language=en-US&page=1")
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiOTFiZmJjYWZhMjgyMmNlMmZlNWUwYzJmNzVmNGUzOCIsIm5iZiI6MTcyMDQ0NDMxOS45MzcxNzgsInN1YiI6IjY2ODkzMzJjN2M0MmZjMTA3MjllZGY3MyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.9IFGousfc_G-F8eewOmrv3ehTOh4LumXn4QKtUorOqQ")
    suspend fun getMoviesBySearch(@Query("query") query: String): MovieResponse

    @GET("genre/movie/list?language=en")
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiOTFiZmJjYWZhMjgyMmNlMmZlNWUwYzJmNzVmNGUzOCIsIm5iZiI6MTcyMDQ0NDMxOS45MzcxNzgsInN1YiI6IjY2ODkzMzJjN2M0MmZjMTA3MjllZGY3MyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.9IFGousfc_G-F8eewOmrv3ehTOh4LumXn4QKtUorOqQ")
    suspend fun getCategoryTitle(): CategoryResponse

    @GET("discover/movie")
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiOTFiZmJjYWZhMjgyMmNlMmZlNWUwYzJmNzVmNGUzOCIsIm5iZiI6MTcyMDQ0NDMxOS45MzcxNzgsInN1YiI6IjY2ODkzMzJjN2M0MmZjMTA3MjllZGY3MyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.9IFGousfc_G-F8eewOmrv3ehTOh4LumXn4QKtUorOqQ")
    suspend fun getMoviesByCategory(@Query("with_genres") category: String): MovieResponse

}