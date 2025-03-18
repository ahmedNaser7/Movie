package com.example.moviesapp.core.data.datasource

import com.example.moviesapp.core.data.network.MovieService
import com.example.moviesapp.core.domain.datasource.BrowseDataSource
import com.example.moviesapp.core.domain.model.category.CategoryResponse

class BrowseDataSourceImpl(
    private val movieService: MovieService
):BrowseDataSource {
    override suspend fun getCategoryTitle(): CategoryResponse {
        return movieService.getCategoryTitle()
    }
}