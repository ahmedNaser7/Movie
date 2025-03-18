package com.example.moviesapp



import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.moviesapp.core.navigation.MovieAppNavHost
import com.example.moviesapp.core.navigation.MovieBottomAppBar
import com.example.moviesapp.ui.theme.Black
import com.example.moviesapp.core.navigation.MovieScreens

@Composable
fun MovieApp() {
    MovieAppContent()
}

@Composable
fun MovieAppContent(
) {
    val navController = rememberNavController()
    val selected = remember { mutableStateOf(Icons.Default.Home) }
    val currentPage = remember { mutableStateOf(MovieScreens.Home) }

    Scaffold(
        containerColor = Black,
        bottomBar = {
            MovieBottomAppBar(
                selected = selected,
                currentPage = currentPage,
                navController = navController,
            )
        }
    ) {
        MovieAppNavHost(navController = navController, paddingValues = it)
    }
}



