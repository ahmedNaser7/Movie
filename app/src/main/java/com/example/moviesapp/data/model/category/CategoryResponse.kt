package com.example.moviesapp.data.model.category

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
	@field:SerializedName("genres")
	val genres: List<Category>? = null
)

data class Category(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
