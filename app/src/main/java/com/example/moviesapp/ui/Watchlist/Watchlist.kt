package com.example.moviesapp.ui.Watchlist


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviesapp.R
import com.example.moviesapp.data.datasource.RetrofitInstance.imageUrl
import com.example.moviesapp.data.model.movie.Movie
import com.example.moviesapp.fakedata.Test.watchListItems
import com.example.moviesapp.fakedata.Test.watchListMovies
import com.example.moviesapp.theme.Orange
import com.example.moviesapp.viewmodel.MainViewModel
import com.google.accompanist.glide.rememberGlidePainter

@Composable
fun Watchlist(viewModel: MainViewModel) {
    val movie by viewModel.movie.collectAsState()
    Log.d("WATCHLIST", "movie: ${watchListMovies.size}")
    Text(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 5.dp, top = 5.dp),
        text = "Watchlist",
        fontWeight = FontWeight.Bold,
        color = White,
        fontSize = 25.sp
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 37.dp, start = 10.dp, end = 10.dp),
    ) {
        itemsIndexed(watchListMovies.toList()) { index, item ->
            RowItem(item)
            Spacer(modifier = Modifier.height(10.dp))
            LineSpacer()
            Spacer(modifier = Modifier.height(10.dp))
        }
    }

    LaunchedEffect(Unit){
        watchListItems.forEach {
            Log.d("WATCHLIST", "movie: $it")
            viewModel.getMovieDetails(it.toString())
            watchListMovies.add(movie)
        }
    }
}

@Composable
fun LineSpacer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 8.dp)
            .height(1.dp)
            .background(Gray)
    )
}

@Composable
fun RowItem(item: Movie) {
    if(item.id != null) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, end = 8.dp)
        ) {
            Image(
                modifier = Modifier
                    .height(130.dp)
                    .width(160.dp),
                painter = rememberGlidePainter(request = imageUrl + item.posterPath),
                contentDescription = ""
            )
            Icon(
                modifier = Modifier.padding(top = 3.dp),
                tint = Orange,
                painter = painterResource(id = R.drawable.ic_bookmark),
                contentDescription = ""
            )
            Icon(
                modifier = Modifier
                    .fillMaxSize()
                    .size(36.dp)
                    .padding(top = 3.dp, end = 330.dp),
                imageVector = Icons.Default.Done,
                tint = White,
                contentDescription = ""
            )
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 30.dp, start = 177.dp),
                text = item.originalTitle ?: "",
                maxLines = 1,
                color = White,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 50.dp, start = 177.dp),
                text = item.releaseDate ?: "",
                maxLines = 1,
                color = Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 70.dp, start = 177.dp),
                text = item.overview ?: "",
                maxLines = 1,
                color = Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true, backgroundColor = 0xFF000000, showBackground = true)
fun PreviewWatchlist() {
    Watchlist(MainViewModel())
}