package com.example.moviesapp.ui.composable

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.moviesapp.R

@Composable
fun IconButton(
    modifier: Modifier,
    selected: MutableState<ImageVector>,
    navController: NavHostController,
    resourceImage: Int?=null,
    imageVector: ImageVector?=null,
    name: String
) {
    val icon = ImageVector.vectorResource(id = resourceImage?: R.drawable.ic_launcher_background)

    IconButton(
        onClick = {
            selected.value = if (resourceImage==null) imageVector!! else icon
            navController.navigate(name) {
                popUpToId
            }
        },
        modifier = modifier
    ) {
        Icon(
            imageVector = if (resourceImage==null)imageVector!! else icon,
            contentDescription = name,
            modifier = Modifier.size(30.dp),
            tint = if (selected.value == if (resourceImage==null)imageVector!! else icon) Color.Yellow else Color.White
        )
    }
}