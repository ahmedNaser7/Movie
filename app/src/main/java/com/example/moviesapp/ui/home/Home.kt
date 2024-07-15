package com.example.moviesapp.ui.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviesapp.R
import com.example.moviesapp.theme.Black
import com.example.moviesapp.theme.Gray
import com.example.moviesapp.theme.LightGray
import com.example.moviesapp.theme.Yellow
import com.example.moviesapp.theme.backgroundGray
import com.example.moviesapp.viewmodel.MainViewModel


@Composable
fun Home(viewModel: MainViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Black)){
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .height(300.dp),
                painter = painterResource(id = R.drawable.ex_image),
                contentDescription = "image_discover"
            )
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(120.dp),
                painter = painterResource(id = R.drawable.icon_play),
                contentDescription = "image_discover"
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 140.dp, start = 20.dp),
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    alignment = Alignment.BottomStart,
                    painter = painterResource(id = R.drawable.image_dora),
                    contentDescription = "image_discover"
                )
                Icon(
                    tint = LightGray,
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_bookmark)
                    , contentDescription = "")
                Icon(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(19.dp),
                    tint = Color.White,
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 130.dp, start = 120.dp),
                    text = "Dora and the lost city of gold",
                    color = Color.White,
                    fontSize = 14.sp
                )
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.BottomCenter)
                        .padding(top = 145.dp, start = 120.dp),
                    text = "2019  PG-13  2h 7m",
                    color = Gray,
                    fontSize = 10.sp
                )

            }
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(top = 20.dp)
                .background(backgroundGray),
        ){
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 4.dp),
                text = "New Releases ",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            LazyRow (
                Modifier.fillMaxSize()
                ,
            ){
                items(10) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(140.dp)
                            .width(110.dp)
                            .padding(10.dp)
                    ) {
                        Image(
                            modifier = Modifier.fillMaxSize(),
                            alignment = Alignment.BottomStart,
                            painter = painterResource(id = R.drawable.image_dora),
                            contentDescription = "image_discover"
                        )
                        Icon(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 70.dp, top = 1.dp)
                                .size(25.dp),
                            tint = LightGray,
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_bookmark)
                            ,contentDescription = ""
                        )
                        Icon(
                            modifier = Modifier
                                .size(22.dp)
                                .padding(start = 2.dp, end = 5.dp, top = 2.dp),
                            tint = Color.White,
                            imageVector = Icons.Default.Add,
                            contentDescription = ""
                        )
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(top = 20.dp)
                .background(backgroundGray),
        ){
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 4.dp),
                text = "Recomended",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            LazyRow (
                Modifier.fillMaxSize()
                ,
            ){
                items(10) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(160.dp)
                            .width(110.dp)
                            .padding(10.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(bottom = 40.dp),
                            alignment = Alignment.BottomStart,
                            painter = painterResource(id = R.drawable.image_dora),
                            contentDescription = "image_discover"
                        )
                        Icon(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 70.dp, top = 1.dp)
                                .size(25.dp),
                            tint = LightGray,
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_bookmark)
                            ,contentDescription = ""
                        )
                        Icon(
                            modifier = Modifier
                                .size(22.dp)
                                .padding(start = 2.dp, end = 5.dp, top = 2.dp),
                            tint = Color.White,
                            imageVector = Icons.Default.Add,
                            contentDescription = ""
                        )
                        Row (
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 145.dp)
                        ){
                            Icon(
                                modifier = Modifier.size(13.dp),
                                painter = painterResource(id = R.drawable.ic_star),
                                tint = Yellow,
                                contentDescription = ""
                            )
                            Text(
                                modifier = Modifier.fillMaxSize().padding(start = 5.dp),
                                text = "7.7",
                                color = Color.White,
                                fontSize = 15.sp
                            )
                        }

                        Text(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 155.dp),
                            text = "Deadpool 2",
                            color = Color.White,
                            fontSize = 10.sp
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 165.dp),
                            text = "2018  R  1h 59m",
                            color = Color.White,
                            fontSize = 10.sp
                        )

                    }
                }
            }
        }

    }
    LaunchedEffect(Unit) {
        viewModel.getPopularMovies()
    }
}

@Composable
@Preview(showSystemUi = true, backgroundColor = 0xFF000000, showBackground = true)
fun PreviewHome() {
    Home(viewModel = MainViewModel())
}