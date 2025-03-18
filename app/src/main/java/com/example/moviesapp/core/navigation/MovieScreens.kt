package com.example.moviesapp.core.navigation

enum class MovieScreens(val route: String) {
    Home("home"),
    Search("search"),
    Browse("browse"),
    Watchlist("watchlist"),
    BrowseDetails("browseDetails"),
    MovieDetails("movieDetails");

    companion object {
        val entries = listOf(Home, Search, Browse, Watchlist)
    }
}
