package com.example.moviesapp.core.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.moviesapp.movie.presentation.browse.Browse
import com.example.moviesapp.movie.presentation.browse.BrowseDetails
import com.example.moviesapp.movie.presentation.home.MovieDetails
import com.example.moviesapp.movie.presentation.search.Search
import com.example.moviesapp.MovieViewModel
import com.example.moviesapp.movie.presentation.home.HomeRoot
import com.example.moviesapp.movie.presentation.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun MovieAppNavHost(
    navController: NavHostController,
    movieViewModel: MovieViewModel= koinViewModel(),
    homeViewModel: HomeViewModel = koinViewModel(),
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = MovieAppScreen.Home.route,
        modifier = Modifier.padding(paddingValues),
    ) {
        composable(MovieAppScreen.Home.route)   { HomeRoot(homeViewModel,navController)  }
        composable(MovieAppScreen.Search.route) { Search(movieViewModel,navController) }
        composable(MovieAppScreen.Browse.route) { Browse(movieViewModel,navController) }
//        composable(MovieAppScreen.Watchlist.route) { Watchlist(movieViewModel) }
        composable(
            MovieAppScreen.MovieDetails.route + "/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })
        )
        {entry ->
            MovieDetails(navController, movieViewModel,entry.arguments?.getString("movieId")?:"272")
        }

        composable(
            MovieAppScreen.BrowseDetails.route + "/{categoryId}",
            arguments = listOf(navArgument("categoryId") { type = NavType.StringType })
        )
        {entry ->
            BrowseDetails( movieViewModel,entry.arguments?.getString("categoryId")?:"19", navController)
        }

    }
}