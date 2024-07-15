package com.example.moviesapp.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(

	@field:SerializedName("page")
	val page: Int? ,

	@field:SerializedName("total_pages")
	val totalPages: Int? ,

	@field:SerializedName("results")
	val results: List<Movie>? ,

	@field:SerializedName("total_results")
	val totalResults: Int?
)

