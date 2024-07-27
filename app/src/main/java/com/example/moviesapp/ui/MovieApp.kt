@file:Suppress("DEPRECATED_ACCESS_TO_ENUM_ENTRY_COMPANION_PROPERTY")

package com.example.moviesapp.ui



import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.moviesapp.R
import com.example.moviesapp.navigation.MovieAppNavHost
import com.example.moviesapp.theme.Black
import com.example.moviesapp.theme.LightBlack
import com.example.moviesapp.theme.Orange
import com.example.moviesapp.ui.Watchlist.Watchlist
import com.example.moviesapp.ui.browse.Browse
import com.example.moviesapp.ui.home.Home
import com.example.moviesapp.ui.search.Search
import com.example.moviesapp.viewmodel.MainViewModel

@Composable
fun MovieApp(viewModel: MainViewModel) {
    MovieAppContent(viewModel = viewModel)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieAppContent(
    viewModel: MainViewModel
) {
    val navController = rememberNavController()
    val selected = remember { mutableStateOf(Icons.Default.Home) }
    val currentPage = remember { mutableStateOf(MovieAppScreen.Home) }

    Scaffold(
        containerColor = Black,
        bottomBar = {
            BottomAppBar(containerColor = LightBlack) {
                MovieAppScreen.entries.forEachIndexed { index, screen ->
                    IconButton(
                        modifier = Modifier.weight(1f),
                        selected = selected,
                        currentPage = currentPage,
                        navController = navController,
                        imageVector = when (screen) {
                            MovieAppScreen.Home -> Icons.Default.Home
                            MovieAppScreen.Search -> Icons.Default.Search
                            MovieAppScreen.Browse -> ImageVector.vectorResource(id = R.drawable.icon_browse)
                            MovieAppScreen.Watchlist -> ImageVector.vectorResource(id = R.drawable.icon_watchlist)
                            else -> Icons.Default.Home
                        },
                        name = screen.route,
                        pageState = index
                    )
                }
            }
        }
    ) {


        MovieAppNavHost(navController = navController, viewModel = viewModel, paddingValues = it)
    }
}



@Composable
fun IconButton(
    modifier: Modifier,
    selected: MutableState<ImageVector>,
    currentPage: MutableState<MovieAppScreen>,
    navController: NavHostController,
    imageVector: ImageVector,
    name: String,
    pageState: Int,
) {
    androidx.compose.material3.IconButton(
        onClick = {
            selected.value = imageVector
            currentPage.value = MovieAppScreen.entries[pageState]
            navController.navigate(currentPage.value.route){popUpTo(0)}
        },
        modifier = modifier
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = name,
            modifier = Modifier.size(30.dp),
            tint = if (selected.value == imageVector) Orange else Color.White
        )
    }
}




@Composable
@Preview(showSystemUi = true)
fun MovieAppPreview() {
    MovieApp(MainViewModel())
}