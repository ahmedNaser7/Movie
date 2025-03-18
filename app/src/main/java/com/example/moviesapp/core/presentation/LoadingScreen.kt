package com.example.moviesapp.core.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.moviesapp.ui.theme.Yellow

@Composable
fun LoadingScreen(modifier: Modifier, loading: Boolean) {
    if(loading){
        Box(modifier = modifier, contentAlignment = Alignment.Center){
            CircularProgressIndicator(
                color = Yellow
            )
        }
    }
}