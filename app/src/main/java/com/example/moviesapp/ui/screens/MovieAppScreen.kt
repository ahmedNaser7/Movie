package com.example.moviesapp.ui.screens

enum class MovieAppScreen(val route: String) {
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
