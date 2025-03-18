package com.example.moviesapp.core.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.moviesapp.R
import com.example.moviesapp.ui.theme.LightBlack
import com.example.moviesapp.ui.theme.Orange

@Composable
fun MovieBottomAppBar(
    selected: MutableState<ImageVector>,
    currentPage: MutableState<MovieScreens>,
    navController: NavHostController,
) {
    BottomAppBar(containerColor = LightBlack) {
        MovieScreens.Companion.entries.forEachIndexed { index, screen ->
            IconButton(
                modifier = Modifier.weight(1f),
                selected = selected,
                currentPage = currentPage,
                navController = navController,
                imageVector = when (screen) {
                    MovieScreens.Home -> Icons.Default.Home
                    MovieScreens.Search -> Icons.Default.Search
                    MovieScreens.Browse -> ImageVector.vectorResource(id = R.drawable.icon_browse)
                    MovieScreens.Watchlist -> ImageVector.vectorResource(id = R.drawable.icon_watchlist)
                    else -> Icons.Default.Home
                },
                name = screen.route,
                pageState = index
            )
        }
    }
}


@Composable
fun IconButton(
    modifier: Modifier,
    selected: MutableState<ImageVector>,
    currentPage: MutableState<MovieScreens>,
    navController: NavHostController,
    imageVector: ImageVector,
    name: String,
    pageState: Int,
) {
    androidx.compose.material3.IconButton(
        onClick = {
            selected.value = imageVector
            currentPage.value = MovieScreens.Companion.entries[pageState]
            navController.navigate(currentPage.value.route) { popUpTo(0) }
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
