package com.example.moviesapp.ui.home


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moviesapp.R
import com.example.moviesapp.data.datasource.RetrofitInstance.imageUrl
import com.example.moviesapp.data.model.movie.Movie
import com.example.moviesapp.fakedata.Test
import com.example.moviesapp.fakedata.Test.watchListItems
import com.example.moviesapp.theme.Black
import com.example.moviesapp.theme.DarkGray
import com.example.moviesapp.theme.LightGray
import com.example.moviesapp.theme.MyGray
import com.example.moviesapp.theme.Yellow
import com.example.moviesapp.theme.backgroundGray
import com.example.moviesapp.viewmodel.MainViewModel
import com.google.accompanist.glide.rememberGlidePainter


@Composable
fun Home(viewModel: MainViewModel,navController: NavController) {

    val recommendedMovies by viewModel.popularMovies.collectAsState()
    val releasesMovies = viewModel.releasesMovies
    val lastMovie = viewModel.lastMovie

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),

    ) {

        RecommendationMovie(lastMovie,navController)

        // New Releases
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(top = 30.dp)
                .background(backgroundGray),
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, top = 4.dp),
                text = "New Releases ",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            LazyRow(
                Modifier
                    .fillMaxSize()
                    .height(180.dp)
                    .padding(start = 5.dp, top = 9.dp),
            ) {
                itemsIndexed(releasesMovies) { index , item ->
                    Spacer(modifier = Modifier.width(12.dp))
                    RowItemsReleases(item,navController)
                }
            }
        }

    // Recommended
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(top = 12.dp)
                .background(backgroundGray),
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, top = 4.dp),
                text = "Recommended",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            LazyRow(
                Modifier
                    .fillMaxSize()
                    .height(180.dp)
                    .padding(start = 8.dp, top = 9.dp),
            ) {
                itemsIndexed(recommendedMovies) { index , item ->
                    Spacer(modifier = Modifier.width(12.dp))
                    RowItemsRecommended(item,navController)
                }

            }
        }

    }


    LaunchedEffect(Unit) {
        viewModel.getRecommendedMovies()
        viewModel.getReleasesMovies()
        viewModel.getLastMovie()
    }
}

@Composable
fun RecommendationMovie(lastMovie: Movie, navController: NavController) {
    val movie =  if (lastMovie.id == null) {
        Test.movies[0]
    } else {
        lastMovie
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(310.dp)
            .background(Black)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(270.dp),
            painter = rememberGlidePainter(request = imageUrl + movie.backdropPath),
            contentDescription = "image_discover"
        )
        IconButton(
            modifier = Modifier
                .fillMaxSize()
                .padding(120.dp),
            onClick = {
                navController.navigate("MovieDetails/${movie.id}")
            }
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_play),
                contentDescription = "image_discover"
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 140.dp, start = 20.dp)
                .clickable {
                    navController.navigate("MovieDetails/${movie.id}")
                }
            ,
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                alignment = Alignment.BottomStart,
                painter = rememberGlidePainter(request = imageUrl + movie.posterPath),
                contentDescription = "image_discover"
            )
            Icon(
                tint = LightGray,
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_bookmark),
                contentDescription = ""
            )
            Icon(
                modifier = Modifier
                    .padding(4.dp)
                    .size(19.dp)
                    .clickable {
                        watchListItems.add(movie.id!!)
                    }
                ,
                tint = Color.White,
                imageVector = Icons.Default.Add,
                contentDescription = ""
            )
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 130.dp, start = 120.dp),
                text = movie.title!!,
                color = Color.White,
                fontSize = 14.sp
            )
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.BottomCenter)
                    .padding(top = 150.dp, start = 120.dp),
                text = movie.releaseDate!!,
                color = MyGray,
                fontSize = 12.sp
            )

        }
    }
}


@Composable
fun RowItemsRecommended(movie:Movie,navController: NavController) {
        Box(
            modifier = Modifier
                .height(193.dp)
                .width(100.dp)
                .background(DarkGray)
                .clip(RoundedCornerShape(4.dp))
                .shadow(1.dp, spotColor = Black)
                .clickable {
                    navController.navigate("MovieDetails/${movie.id}")
                }

        ) {
            Image(
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)
                    .clip(RoundedCornerShape(4.dp)),
                painter = rememberGlidePainter(request = imageUrl+movie.posterPath),
                contentDescription = "image_discover"
            )
            Icon(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(30.dp)
                    .padding(end = 77.dp),
                tint = LightGray,
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_bookmark),
                contentDescription = ""
            )
            IconButton(
                modifier = Modifier
                    .size(35.dp)
                    .padding(bottom = 10.dp, end = 11.dp),
                onClick = {
                    watchListItems.add(movie.id!!)
                }
            ) {
                Icon(
                    tint = Color.White,
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 3.dp, top = 150.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .size(17.dp)
                        .padding(top = 7.dp),
                    painter = painterResource(id = R.drawable.ic_star),
                    tint = Yellow,
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 3.dp, top = 1.dp),
                    text = movie.voteAverage.toString(),
                    color = Color.White,
                    fontSize = 11.sp
                )
            }

            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 5.dp, top = 162.dp),
                text = movie.title!!,
                color = Color.White,
                fontSize = 10.sp
            )
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 5.dp, top = 173.dp),
                text = movie.releaseDate!!,
                color = Color.White,
                fontSize = 10.sp
            )
        }
}

@Composable
fun RowItemsReleases(movie: Movie,navController: NavController) {
    Box(
        modifier = Modifier
            .height(150.dp) //Todo (edit it to 180.dp)
            .width(100.dp)
            .clickable {
                navController.navigate("MovieDetails/${movie.id}")
            }
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .width(120.dp)
                .clip(RoundedCornerShape(4.dp)),
            painter = rememberGlidePainter(request = imageUrl + movie.posterPath),
            contentDescription = "image_discover"
        )
        Icon(
            modifier = Modifier
                .fillMaxWidth()
                .size(30.dp)
                .padding(end = 76.dp),
            tint = LightGray,
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_bookmark),
            contentDescription = ""
        )
        IconButton(
            modifier = Modifier
                .size(35.dp)
                .padding(bottom = 10.dp, end = 10.dp),
            onClick = {
                watchListItems.add(movie.id!!)
            }
        ) {
            Icon(
                tint =  Color.White,
                imageVector =  Icons.Default.Add,
                contentDescription = ""
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true, backgroundColor = 0xFF000000, showBackground = true)
fun PreviewHome() {
    Home(viewModel = MainViewModel(),navController = NavController(LocalContext.current))
}


