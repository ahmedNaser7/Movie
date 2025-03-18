package com.example.moviesapp.movie.presentation.browse

import com.example.moviesapp.core.domain.model.category.Category

data class BrowseState(
    val isLoading:Boolean = false,
    val isSuccess:Boolean = false,
    val error:String = "",
    val categories:List<Category> = emptyList(),
)
