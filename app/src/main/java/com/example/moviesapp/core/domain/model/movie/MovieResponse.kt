package com.example.moviesapp.core.domain.model.movie

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @field:SerializedName("page")
	val page: Int?,

    @field:SerializedName("total_pages")
	val totalPages: Int?,

    @field:SerializedName("results")
	val results: List<Movie>?,

    @field:SerializedName("total_results")
	val totalResults: Int?,

    @field:SerializedName("dates")
    val dates: Dates? = null,
)

