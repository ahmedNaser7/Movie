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
import com.example.moviesapp.ui.screens.MovieAppScreen
import com.example.moviesapp.ui.Watchlist.Watchlist
import com.example.moviesapp.ui.browse.Browse
import com.example.moviesapp.ui.browse.BrowseDetails
import com.example.moviesapp.ui.home.Home
import com.example.moviesapp.ui.home.MovieDetails
import com.example.moviesapp.ui.search.Search
import com.example.moviesapp.viewmodel.MovieViewModel


@Composable
fun MovieAppNavHost(
    navController: NavHostController,
    viewModel: MovieViewModel,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = MovieAppScreen.Home.route,
        modifier = Modifier.padding(paddingValues),
    ) {
        composable(MovieAppScreen.Home.route)   { Home(viewModel,navController)  }
        composable(MovieAppScreen.Search.route) { Search(viewModel,navController) }
        composable(MovieAppScreen.Browse.route) { Browse(viewModel,navController) }
        composable(MovieAppScreen.Watchlist.route) { Watchlist(viewModel) }
        composable(
            MovieAppScreen.MovieDetails.route + "/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })
        )
        {entry ->
            MovieDetails(navController, viewModel,entry.arguments?.getString("movieId")?:"272")
        }

        composable(
            MovieAppScreen.BrowseDetails.route + "/{categoryId}",
            arguments = listOf(navArgument("categoryId") { type = NavType.StringType })
        )
        {entry ->
            BrowseDetails( viewModel,entry.arguments?.getString("categoryId")?:"19", navController)
        }

    }
}