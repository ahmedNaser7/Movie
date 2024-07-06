package com.example.moviesapp.ui.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun Search(){
    Text(modifier = Modifier.fillMaxWidth(), text = "search view", fontSize = 40.sp)
}