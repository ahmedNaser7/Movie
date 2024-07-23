package com.example.moviesapp.ui.search

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.moviesapp.R
import com.example.moviesapp.data.datasource.RetrofitInstance.imageUrl
import com.example.moviesapp.data.model.movie.Movie
import com.example.moviesapp.theme.LightGray
import com.example.moviesapp.theme.TranspositionWhite
import com.example.moviesapp.ui.Watchlist.LineSpacer
import com.example.moviesapp.viewmodel.MainViewModel
import com.google.accompanist.glide.rememberGlidePainter

@Composable
fun Search(viewModel: MainViewModel) {
    var query by remember { mutableStateOf("") }
    val movies = viewModel.searchedMovies
        searchBox(query) { newQuery ->
            query = newQuery
            viewModel.getSearchingMovies(query)
        }
        if(movies.lastIndex == 0 || movies.isEmpty()) {
            Image(
                modifier = Modifier.fillMaxSize().padding(140.dp),
                alignment = Alignment.CenterEnd,
                painter = painterResource(id = R.drawable.img_not_found),
                contentDescription = " "
            )
        }else{
            MovieList(movies)
        }

}

@Composable
fun MovieList(moviesList: List<Movie>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp, start = 12.dp, end = 10.dp)
    ) {
        itemsIndexed(moviesList) { index, item ->
            RowItemSearch(item)
            Spacer(modifier = Modifier.height(10.dp))
            LineSpacer()
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun searchBox(query: String, onQueryChange: (String) -> Unit) {
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
fun RowItemSearch(movie: Movie) {
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

@Composable
@Preview(showSystemUi = true, backgroundColor = 0xFF000000, showBackground = true)
fun PreviewSearch() {
    Search(viewModel = MainViewModel())
}
