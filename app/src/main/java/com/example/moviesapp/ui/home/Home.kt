package com.example.moviesapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviesapp.ui.theme.Black
import com.example.moviesapp.ui.theme.Yellow

@Composable
fun Home() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        this.item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Yellow)
                    .padding(20.dp)
                    .size(100.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Black)
                    .size(100.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Yellow)
                    .padding(20.dp)
                    .size(100.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Black)
                    .padding(20.dp)
                    .size(100.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Black)
                    .padding(20.dp)
                    .size(100.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Yellow)
                    .padding(20.dp)
                    .size(100.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Black)
                    .padding(20.dp)
                    .size(100.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Yellow)
                    .padding(20.dp)
                    .size(100.dp)
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun PreviewHome(){
    Home()
}