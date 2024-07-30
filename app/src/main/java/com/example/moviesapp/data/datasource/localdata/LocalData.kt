package com.example.moviesapp.data.datasource.localdata

import com.example.moviesapp.data.model.movie.Movie

object LocalData {

    val watchListItems:MutableList<Int> = mutableListOf()
    val watchListMovies = mutableSetOf<Movie>()

    val movies = listOf(
        Movie(
            id = 1,
            title = "Movie 1",
            overview = "Description 1",
            posterPath = "poster1.jpg",
            adult = true,
            backdropPath = "vpnVM9B6NMmQpWeZvzLvDESb2QY.jpg",
            genreIds = listOf(1, 2, 3),
            originalLanguage = "en",
            originalTitle = "Original Title 1",
            popularity = 5.0,
            releaseDate = "2023-07-01",
            video = false,
            voteAverage = 4.5,
            voteCount = 1000
        ),
        Movie(
            id = 2,
            title = "Movie 2",
            overview = "Description 2",
            posterPath = "poster2.jpg",
            adult = false,
            backdropPath = "backdrop2.jpg",
            genreIds = listOf(4, 5, 6),
            originalLanguage = "fr",
            originalTitle = "Original Title 2",
            popularity = 6.0,
            releaseDate = "2023-07-02",
            video = true,
            voteAverage = 3.5,
            voteCount = 2000
        )
    )




}