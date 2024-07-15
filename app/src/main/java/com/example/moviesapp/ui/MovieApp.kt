package com.example.moviesapp.ui


import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviesapp.R
import com.example.moviesapp.ui.Watchlist.Watchlist
import com.example.moviesapp.ui.browse.Browse
import com.example.moviesapp.ui.composable.IconButton
import com.example.moviesapp.ui.home.Home
import com.example.moviesapp.ui.search.Search
import com.example.moviesapp.theme.Black
import com.example.moviesapp.theme.LightBlack
import com.example.moviesapp.viewmodel.MainViewModel

@Composable
fun MovieApp(viewModel: MainViewModel) {
    MovieAppContent(viewModel = viewModel)
}

@Composable
fun MovieAppContent(
    viewModel: MainViewModel
) {
    val navController = rememberNavController()
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    Scaffold(
        containerColor = Black,
        bottomBar = {
            BottomAppBar(
                containerColor = LightBlack,
            ) {
                IconButton(
                    modifier = Modifier.weight(1f),
                    selected = selected,
                    navController = navController,
                    imageVector = Icons.Default.Home,
                    name = "Home"
                )
                IconButton(
                    modifier = Modifier.weight(1f),
                    selected = selected,
                    navController = navController,
                    imageVector = Icons.Default.Search,
                    name = "Search"
                )
                IconButton(
                    modifier = Modifier.weight(1f),
                    selected = selected,
                    navController = navController,
                    resourceImage = R.drawable.icon_browse,
                    name = "Browse"
                )
                IconButton(
                    modifier = Modifier.weight(1f),
                    selected = selected,
                    navController = navController,
                    resourceImage = R.drawable.icon_watchlist,
                    name = "Watchlist"
                )
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screens.Home.screen,
            modifier = Modifier.padding(it),
        ) {
            composable(Screens.Home.screen) { Home(viewModel = viewModel) }
            composable(Screens.Search.screen) { Search() }
            composable(Screens.Browse.screen) { Browse() }
            composable(Screens.Watchlist.screen) { Watchlist() }
        }

    }
}


@Composable
@Preview(showSystemUi = true)
fun MovieAppPreview() {
    MovieApp(MainViewModel())
}