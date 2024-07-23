package com.example.moviesapp.fakedata

import com.example.moviesapp.R
import com.example.moviesapp.data.model.movie.Movie

object Test {
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

    val CategoryItems = listOf(
        FakeCategory(
            id = 1,
            name = "Action",
            image = R.drawable.img_cate
        ),
        FakeCategory(
            id = 2,
            name = "Comedy",
            image = R.drawable.img_cate
        ),
        FakeCategory(
            id = 3,
            name = "Drama",
            image = R.drawable.img_cate
        ),
        FakeCategory(
            id = 4,
            name = "Horror",
            image = R.drawable.img_cate
        ),
        FakeCategory(
            id = 5,
            name = "Romance",
            image = R.drawable.img_cate
        ),
        FakeCategory(
            id = 6,
            name = "Thriller",
            image = R.drawable.img_cate
        ),
        FakeCategory(
            id = 7,
            name = "Adventure",
            image = R.drawable.img_cate
        ),
        FakeCategory(
            id = 8,
            name = "Animation",
            image = R.drawable.img_cate
        ),
        FakeCategory(
            id = 9,
            name = "Documentary",
            image = R.drawable.img_cate
        ),
        FakeCategory(
            id = 10,
            name = "Family",
            image = R.drawable.img_cate
        ),
        FakeCategory(
            id = 11,
            name = "Fantasy",
            image = R.drawable.img_cate
        ),
        FakeCategory(
            id = 12,
            name = "History",
            image = R.drawable.img_cate
        ),
        FakeCategory(
            id = 13,
            name = "Mystery",
            image = R.drawable.img_cate
        ),
        FakeCategory(
            id = 14,
            name = "Science Fiction",
            image = R.drawable.img_cate
        ),
        FakeCategory(
            id = 15,
            name = "TV Movie",
            image = R.drawable.img_cate
        ),
    )

    val moviesUi = listOf(
        MovieUi(
            id = 1,
            title = "Movie 1",
            image = R.drawable.image_watchlist,
            rating = 4.5f,
            description = "Description 1",
            watchList = true,
        ),
        MovieUi(
            id = 2,
            title = "Movie 2",
            image = R.drawable.image_watchlist,
            rating = 3.5f,
            description = "Description 2",
            watchList = true,
        ),
        MovieUi(
            id = 3,
            title = "Movie 3",
            image = R.drawable.image_watchlist,
            rating = 5.0f,
            description = "Description 3",
            watchList = true,
        ),
        MovieUi(
            id = 4,
            title = "Movie 4",
            image = R.drawable.image_watchlist,
            rating = 4.0f,
            description = "Description 4",
            watchList = true,
        ),
        MovieUi(
            id = 5,
            title = "Movie 5",
            image = R.drawable.image_watchlist,
            rating = 2.5f,
            description = "Description 5",
            watchList = true,
        ),
        MovieUi(
            id = 6,
            title = "Movie 6",
            image = R.drawable.image_watchlist,
            rating = 3.0f,
            description = "Description 6",
            watchList = true,
            ),
        MovieUi(
            id = 7,
            title = "Movie 7",
            image = R.drawable.image_watchlist,
            rating = 3.0f,
            description = "Description 7",
            watchList = true,
        ),
    )

}