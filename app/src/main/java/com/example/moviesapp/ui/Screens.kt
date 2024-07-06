package com.example.moviesapp.ui

sealed class Screens(val screen:String) {
    data object Home:Screens("Home")
    data object Search:Screens("Search")
    data object Browse:Screens("Browse")
    data object Watchlist:Screens("Watchlist")
}