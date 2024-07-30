package com.example.moviesapp.ui.home


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moviesapp.R
import com.example.moviesapp.data.datasource.network.RetrofitInstance.imageUrl
import com.example.moviesapp.data.model.movie.Movie
import com.example.moviesapp.data.datasource.localdata.LocalData.watchListItems
import com.example.moviesapp.theme.Black
import com.example.moviesapp.theme.DarkGray
import com.example.moviesapp.theme.MyGray
import com.example.moviesapp.theme.LightGray
import com.example.moviesapp.theme.Yellow
import com.example.moviesapp.theme.backgroundGray
import com.example.moviesapp.viewmodel.MovieViewModel
import com.google.accompanist.glide.rememberGlidePainter


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MovieDetails(navController: NavController, viewModel: MovieViewModel, movieId:String){
    val movie by viewModel.movie.collectAsState()
    val similarMovies = viewModel.similarMovies
    Column(
      modifier = Modifier
          .fillMaxSize()
          .verticalScroll(rememberScrollState())
  ){
      Row(
          modifier = Modifier
              .fillMaxWidth()
              .height(40.dp)
      ){
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

          Text(
              modifier = Modifier.padding(start = 22.dp,top = 7.dp),
              text = movie.title?:"",
              fontSize = 20.sp,
              maxLines = 1,
              fontWeight = FontWeight.Bold,
              color = Color.White,
              textAlign = TextAlign.Center
          )
      }
      Box(
          modifier = Modifier
              .fillMaxWidth()
              .height(200.dp)
              .padding(top = 4.dp)
      ){
          Image(
              modifier = Modifier
                  .fillMaxWidth()
                  .height(200.dp),
              painter = rememberGlidePainter(request = imageUrl + movie.backdropPath),
              contentDescription = "image_discover"
          )
      }
      Text(
          modifier = Modifier.padding(start = 22.dp,top = 10.dp),
          text = movie.title?:"",
          fontSize = 20.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White,
          textAlign = TextAlign.Center
      )
      Text(
          modifier = Modifier
              .padding(start = 22.dp, top = 6.dp),
          text = movie.releaseDate?:"",
          color = MyGray,
          fontSize = 12.sp
      )

      Box(
         modifier = Modifier
             .fillMaxWidth()
             .height(220.dp)
             .padding(start = 20.dp, top = 20.dp)
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
                  },
              tint = Color.White,
              imageVector = Icons.Default.Add,
              contentDescription = ""
          )

          FlowRow(
             modifier = Modifier.padding(start = 165.dp, end = 13.dp),
          ){
              if (movie.genres!= null) {
                  repeat(movie.genres!!.size) {
                      ChipItem(movie.genres!![it]?.name?:"Action")
                      Spacer(modifier = Modifier.width(4.dp))
                  }
              }
          }

          Text(
              modifier = Modifier.padding(start = 170.dp, top = 60.dp),
              text = movie.overview?:"",
              maxLines = 5,
              fontSize = 13.sp,
              color = Color.White
          )

          Row(
              modifier = Modifier
                  .fillMaxSize()
                  .padding(start = 170.dp, top = 175.dp)
          ) {
              Icon(
                  modifier = Modifier
                      .size(12.dp)
                      .padding(top = 3.dp),
                  painter = painterResource(id = R.drawable.ic_star),
                  tint = Yellow,
                  contentDescription = ""
              )
              Text(
                  modifier = Modifier
                      .fillMaxSize()
                      .padding(start = 3.dp, top = 1.dp),
                  text = movie.voteAverage.toString()?:"",
                  color = Color.White,
                  fontSize = 11.sp
              )
          }

      }





      // More Like this
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
                  .padding(start = 20.dp, top = 4.dp),
              text = "More Like This",
              color = Color.White,
              fontWeight = FontWeight.Bold
          )
          LazyRow(
              Modifier
                  .fillMaxSize()
                  .height(180.dp)
                  .padding(start = 8.dp, top = 4.dp),
          ) {
              itemsIndexed(similarMovies) {index,item ->
                  Spacer(modifier = Modifier.width(12.dp))
                  RowItem(item,navController)
              }

          }
      }
  }

    LaunchedEffect(Unit) {
        viewModel.getMovieDetails(movieId)
        viewModel.getSimilarMovies(movieId)
    }
}

@Composable
fun RowItem(movie: Movie,navController: NavController) {
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
            painter = rememberGlidePainter(request = imageUrl + movie.posterPath),
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
                    .size(12.dp)
                    .padding(top = 3.dp),
                painter = painterResource(id = R.drawable.ic_star),
                tint = Yellow,
                contentDescription = ""
            )
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 3.dp, top = 1.dp),
                text = movie.voteAverage.toString(),
                maxLines = 1,
                color = Color.White,
                fontSize = 11.sp
            )
        }

        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 5.dp, top = 162.dp),
            text = movie.title?:"",
            maxLines = 1,
            color = Color.White,
            fontSize = 10.sp
        )
        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 5.dp, top = 173.dp),
            text = movie.releaseDate?:"",
            maxLines = 1,
            color = Color.White,
            fontSize = 10.sp
        )
    }
}

@Composable
fun ChipItem(text: String) {
    Card(
        modifier = Modifier
            .width(60.dp)
            .height(30.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(1.dp, Color.Gray),
        colors = CardColors(
            containerColor = backgroundGray,
            disabledContainerColor = backgroundGray ,
            contentColor = Color.White,
            disabledContentColor = Color.White
        ),
    ){
         Text(
             modifier = Modifier.padding(start = 4.dp, top = 3.dp),
             text = text,
             textAlign = TextAlign.Center,
             maxLines = 1,
             fontSize = 11.sp
         )
    }
}

