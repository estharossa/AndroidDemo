package com.example.androiddemo.model

import com.google.gson.annotations.SerializedName

data class MovieAPI(
    val id: String,
    val title: String,
    @SerializedName("vote_average") val voteAverage: String,
    val overview: String,
    @SerializedName("poster_path") val posterPath: String
)
