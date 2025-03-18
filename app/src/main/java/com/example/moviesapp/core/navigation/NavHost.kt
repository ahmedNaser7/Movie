package com.example.moviesapp.core.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.moviesapp.movie.presentation.browse.BrowseDetails
import com.example.moviesapp.movie.presentation.home.MovieDetails
import com.example.moviesapp.movie.presentation.search.Search
import com.example.moviesapp.MovieViewModel
import com.example.moviesapp.movie.presentation.browse.BrowseRoot
import com.example.moviesapp.movie.presentation.browse.BrowseViewModel
import com.example.moviesapp.movie.presentation.home.HomeRoot
import com.example.moviesapp.movie.presentation.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun MovieAppNavHost(
    navController: NavHostController,
    movieViewModel: MovieViewModel= koinViewModel(),
    homeViewModel: HomeViewModel = koinViewModel(),
    browseViewModel: BrowseViewModel = koinViewModel(),
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = MovieScreens.Home.route,
        modifier = Modifier.padding(paddingValues),
    ) {
        composable(MovieScreens.Home.route)   { HomeRoot(homeViewModel,navController)  }
        composable(MovieScreens.Search.route) { Search(movieViewModel,navController) }
        composable(MovieScreens.Browse.route) { BrowseRoot(browseViewModel,navController) }
        composable(MovieScreens.Watchlist.route) { /*Watchlist(movieViewModel)*/ Text(text = "on progress .....") }
        composable(
            MovieScreens.MovieDetails.route + "/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })
        )
        {entry ->
            MovieDetails(navController, movieViewModel,entry.arguments?.getString("movieId")?:"272")
        }

        composable(
            MovieScreens.BrowseDetails.route + "/{categoryId}",
            arguments = listOf(navArgument("categoryId") { type = NavType.StringType })
        )
        {entry ->
            BrowseDetails( movieViewModel,entry.arguments?.getString("categoryId")?:"19", navController)
        }

    }
}