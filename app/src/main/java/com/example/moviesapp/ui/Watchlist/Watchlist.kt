package com.example.moviesapp.ui.Watchlist

import android.graphics.LinearGradient
import androidx.compose.animation.core.LinearEasing
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviesapp.R
import com.example.moviesapp.fakedata.MovieUi
import com.example.moviesapp.fakedata.Test
import com.example.moviesapp.theme.Orange

@Composable
fun Watchlist(){
    Text(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 5.dp, top = 5.dp),
        text = "Watchlist",
        fontWeight = FontWeight.Bold,
        color = White,
        fontSize = 25.sp)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp, start = 10.dp, end = 10.dp),
    ){
        itemsIndexed(Test.moviesUi){index, item ->
            RowItem(item)
            Spacer(modifier = Modifier.height(10.dp))
            LineSpacer()
            Spacer(modifier = Modifier.height(10.dp))
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
fun RowItem(item: MovieUi) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, end = 8.dp)
        ){
            Image(
                modifier = Modifier
                    .height(130.dp)
                    .width(160.dp),
                painter = painterResource(id = item.image),
                contentDescription = "")
            Icon(
                modifier = Modifier.padding( top = 14.dp),
                tint = Orange,
                painter = painterResource(id = R.drawable.ic_bookmark),
                contentDescription ="" )
            Icon(
                modifier = Modifier
                    .fillMaxSize()
                    .size(35.dp)
                    .padding(top = 17.dp, end = 390.dp),
                imageVector = Icons.Default.Done,
                tint = White,
                contentDescription =""
            )
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 30.dp, start = 177.dp),
                text = "Alita Battle Angel",
                color = White,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 50.dp, start = 177.dp),
                text = "2019",
                color = Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 70.dp, start = 177.dp),
                text = "Rosa Salazar, Christoph Waltz",
                color = Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
        }
}

@Composable
@Preview(showSystemUi = true, backgroundColor = 0xFF000000, showBackground = true)
fun PreviewWatchlist(){
  Watchlist()
}