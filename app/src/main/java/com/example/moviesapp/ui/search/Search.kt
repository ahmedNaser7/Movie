package com.example.moviesapp.ui.search


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviesapp.theme.LightGray

@Composable
fun Search(){
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ){
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                value = "",
                onValueChange = {},
                maxLines = 1,
                shape = RoundedCornerShape(30.dp),
                textStyle = TextStyle(color = Color.White,fontSize = 20.sp, textAlign = TextAlign.Center),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = LightGray,
                    unfocusedContainerColor = LightGray,
                    disabledContainerColor = LightGray,
                    )
                )
            Box (
                modifier = Modifier
                    .fillMaxHeight()
                    .background(LightGray)
            )
            Icon(
                modifier = Modifier
                    .size(45.dp)
                    .padding(start = 19.dp, top = 8.dp),
                imageVector = Icons.Default.Search,
                contentDescription = "",
                tint = Color.White,
            )

        }

    }
}

@Composable
@Preview(showSystemUi = true, backgroundColor = 0xFF000000, showBackground = true)
fun PreviewSearch(){
    Search()
}