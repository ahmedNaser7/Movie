package com.example.moviesapp.core.domain.datasource

import com.example.moviesapp.core.domain.model.category.CategoryResponse

interface BrowseDataSource {
   suspend fun getCategoryTitle(): CategoryResponse
}