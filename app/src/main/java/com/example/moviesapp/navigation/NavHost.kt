package com.example.moviesapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.moviesapp.data.model.movie.Movie
import com.example.moviesapp.ui.Screens
import com.example.moviesapp.ui.Watchlist.Watchlist
import com.example.moviesapp.ui.browse.Browse
import com.example.moviesapp.ui.browse.BrowseDetails
import com.example.moviesapp.ui.home.Home
import com.example.moviesapp.ui.home.MovieDetails
import com.example.moviesapp.ui.search.Search
import com.example.moviesapp.viewmodel.MainViewModel


@Composable
fun MovieAppNavHost(
    navController: NavHostController,
    viewModel: MainViewModel,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home.screen,
        modifier = Modifier.padding(paddingValues),
    ) {
        composable(Screens.Home.screen)
        { Home(viewModel = viewModel, navController = navController) }
        composable(Screens.Search.screen) { Search(viewModel) }
        composable(Screens.Browse.screen) { Browse(viewModel,navController) }
        composable(Screens.Watchlist.screen) { Watchlist() }
        composable(
            Screens.MovieDetails.screen + "/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })
        )
        {entry ->
            MovieDetails(navController, viewModel,entry.arguments?.getString("movieId")?:"272")
        }

        composable(
            Screens.BrowseDetails.screen + "/{categoryId}",
            arguments = listOf(navArgument("categoryId") { type = NavType.StringType })
        )
        {entry ->
            BrowseDetails( viewModel,entry.arguments?.getString("categoryId")?:"19", navController)
        }

    }
}