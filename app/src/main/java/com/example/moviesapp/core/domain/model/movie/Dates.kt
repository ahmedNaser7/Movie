package com.example.moviesapp.core.domain.model.movie

import com.google.gson.annotations.SerializedName

data class Dates(
	@field:SerializedName("maximum")
	val maximum: String? = null,
	@field:SerializedName("minimum")
	val minimum: String? = null
)

