package com.example.moviesapp.ui.browse

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moviesapp.R
import com.example.moviesapp.data.model.category.Category
import com.example.moviesapp.theme.TranspositionGray
import com.example.moviesapp.viewmodel.MainViewModel

@Composable
fun Browse(viewModel: MainViewModel,navController: NavController) {
    val category by viewModel.categoryTitle.collectAsState()
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
            .padding(9.dp, top = 23.dp),
        columns = GridCells.Fixed(2)
    ) {
       itemsIndexed(items = category){ index, item ->
           GridItem(item = item,navController)
       }

    }

    LaunchedEffect(Unit) {
        viewModel.getCategoryTitle()
    }

}

@Composable
fun GridItem(item : Category,navController: NavController) {
    Column (
        modifier = Modifier
            .height(200.dp)
            .width(250.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){

        Box(
            modifier = Modifier.fillMaxSize().clickable {
                navController.navigate("BrowseDetails/${item.id}")
            }
        ){
            Image(
                modifier = Modifier
                    .size(180.dp),
                painter = painterResource(id = R.drawable.img_cate),
                contentDescription = "image_browse",
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .width(100.dp)
                    .padding(top = 39.dp, bottom = 19.dp, end = 12.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(TranspositionGray)
            )

            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 80.dp, start = 43.dp),
                maxLines = 1,
                fontWeight = FontWeight.Bold,
                text = item.name!!,
                color = Color.White,
                fontSize = 18.sp,
            )

        }

    }
}

@Composable
@Preview(showSystemUi = true)
fun PreviewBrowse() {
    Browse(MainViewModel(), navController = NavController(LocalContext.current))
}