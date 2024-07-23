package com.example.moviesapp.ui



import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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
                    name = "Home",
                )

                IconButton(
                    modifier = Modifier.weight(1f),
                    selected = selected,
                    navController = navController,
                    imageVector = Icons.Default.Search,
                    name = "Search",
                )
                IconButton(
                    modifier = Modifier.weight(1f),
                    selected = selected,
                    navController = navController,
                    resourceImage = R.drawable.icon_browse,
                    name = "Browse",
                )
                IconButton(
                    modifier = Modifier.weight(1f),
                    selected = selected,
                    navController = navController,
                    resourceImage = R.drawable.icon_watchlist,
                    name = "Watchlist",
                )
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
    navController: NavHostController,
    resourceImage: Int? = null,
    imageVector: ImageVector? = null,
    name: String
) {
    val icon = ImageVector.vectorResource(id = resourceImage ?: R.drawable.ic_launcher_background)

    androidx.compose.material3.IconButton(
        onClick = {
            selected.value = if (resourceImage == null) imageVector!! else icon
            navController.navigate(name) {
                popUpTo(0)
            }
        },
        modifier = modifier
    ) {

        Icon(
            imageVector = if (resourceImage == null) imageVector!! else icon,
            contentDescription = name,
            modifier = Modifier.size(30.dp),
            tint = if (selected.value == if (resourceImage == null) imageVector!! else icon) Orange else Color.White
        )

    }
}

@Composable
@Preview(showSystemUi = true)
fun MovieAppPreview() {
    MovieApp(MainViewModel())
}