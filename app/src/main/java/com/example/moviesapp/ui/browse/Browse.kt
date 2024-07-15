package com.example.moviesapp.ui.browse

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviesapp.fakedata.Category
import com.example.moviesapp.fakedata.Test

@Composable
fun Browse() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp),
        fontSize = 20.sp,
        text = "Browse Category",
        color = Color.White
    )

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(7.dp, top = 23.dp),
        columns = GridCells.Fixed(2)
    ) {
       itemsIndexed(items = Test.CategoryItems){ index, item ->
           GridItem(item = item)
       }

    }

}

@Composable
fun GridItem(item: Category) {
    Column (
        modifier = Modifier
            .height(200.dp)
            .width(250.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Box(modifier = Modifier.fillMaxSize()){
            Image(
                modifier = Modifier
                    .size(180.dp),
                painter = painterResource(id = item.image),
                contentDescription = "image_browse",
            )

            Text(
                modifier = Modifier.fillMaxSize()
                    .padding(top = 80.dp, start = 70.dp),
                text = item.name!!,
                color = Color.White,
                fontSize = 18.sp,
            )
        }

       // TODO(" black background to make the pic more dark")
    }
}

@Composable
@Preview(showSystemUi = true)
fun PreviewBrowse() {
    Browse()
}