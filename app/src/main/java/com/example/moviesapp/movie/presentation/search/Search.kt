package com.example.moviesapp.movie.presentation.search

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moviesapp.R
import com.example.moviesapp.core.data.network.RetrofitInstance.imageUrl
import com.example.moviesapp.core.domain.model.movie.Movie
import com.example.moviesapp.ui.theme.LightGray
import com.example.moviesapp.ui.theme.TranspositionWhite
import com.example.moviesapp.movie.presentation.Watchlist.LineSpacer
import com.example.moviesapp.MovieViewModel
import com.google.accompanist.glide.rememberGlidePainter

@SuppressLint("SuspiciousIndentation")
@Composable
fun Search(viewModel: MovieViewModel, navController: NavController) {
    var query by remember { mutableStateOf("") }
    val movies = viewModel.searchedMovies
        SearchBox(query) { newQuery ->
            query = newQuery
            viewModel.getSearchingMovies(query)
            // after input the word there is a problem of call function again and again
        }

        if(movies.lastIndex == 0 || movies.isEmpty()) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(140.dp),
                alignment = Alignment.CenterEnd,
                painter = painterResource(id = R.drawable.img_not_found),
                contentDescription = " "
            )
        }else{
            MovieList(movies,navController)
        }

}

@Composable
fun MovieList(moviesList: List<Movie>, navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp, start = 12.dp, end = 10.dp)
    ) {
        itemsIndexed(moviesList) { index, item ->
            RowItemSearch(item, navController)
            Spacer(modifier = Modifier.height(10.dp))
            LineSpacer()
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun SearchBox(query: String, onQueryChange: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 17.dp),
                value = query,
                onValueChange = onQueryChange,
                maxLines = 1,
                shape = RoundedCornerShape(30.dp),
                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = LightGray,
                    unfocusedContainerColor = LightGray,
                    disabledContainerColor = LightGray,
                    focusedIndicatorColor = TranspositionWhite,
                    unfocusedIndicatorColor = TranspositionWhite,
                    disabledIndicatorColor = TranspositionWhite
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(LightGray)
            )
            Icon(
                modifier = Modifier
                    .size(55.dp)
                    .padding(start = 30.dp, top = 2.dp),
                imageVector = Icons.Default.Search,
                contentDescription = "",
                tint = Color.White,
            )
        }
    }
}

@Composable
fun RowItemSearch(movie: Movie, navController: NavController) {
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
            text = movie.name ?: "",
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
            text = movie.originalName ?: "",
            maxLines = 1,
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp
        )
    }
}


