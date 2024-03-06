package com.example.androiddemo.model

import com.google.gson.annotations.SerializedName

data class MovieAPIResponse(
    val page: Int,
    val results: List<MovieAPI> = listOf()
)
