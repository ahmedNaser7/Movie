package com.example.moviesapp.ui.browse

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moviesapp.data.datasource.network.RetrofitInstance.imageUrl
import com.example.moviesapp.data.model.movie.Movie
import com.example.moviesapp.ui.Watchlist.LineSpacer
import com.example.moviesapp.viewmodel.MovieViewModel
import com.google.accompanist.glide.rememberGlidePainter


@Composable
fun BrowseDetails(viewModel: MovieViewModel, cateId:String, navController: NavController){
    val moviesOfCategory = viewModel.categoryMovies
    BrowseDetailsAppBar(navController)
    MovieBrowseList(moviesOfCategory,navController)
    LaunchedEffect(Unit) {
        viewModel.getMoviesByCate(cateId)
    }
}

@Composable
fun BrowseDetailsAppBar(navController:NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
    ) {
        IconButton(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Icon(
                modifier = Modifier
                    .size(30.dp),
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                tint = Color.White
            )
        }

    }
}

@Composable
fun MovieBrowseList(moviesList: List<Movie>,navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp, start = 12.dp, end = 10.dp)
    ) {
        itemsIndexed(moviesList) { index, item ->
            RowItemBrowse(item,navController)
            Spacer(modifier = Modifier.height(10.dp))
            LineSpacer()
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun RowItemBrowse(movie: Movie,navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 8.dp)
    ) {
        Image(
            modifier = Modifier
                .height(130.dp)
                .width(160.dp),
            painter = rememberGlidePainter(request = imageUrl + movie.backdropPath),
            contentDescription = null
        )

        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp, start = 177.dp),
            text = movie.title ?: "",
            maxLines = 1,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp, start = 177.dp),
            text = movie.originalLanguage ?: "",
            maxLines = 1,
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp
        )
        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 70.dp, start = 177.dp),
            text = movie.releaseDate ?: "",
            maxLines = 1,
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp
        )
    }
}

