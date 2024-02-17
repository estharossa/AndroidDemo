package com.example.androiddemo.model

import java.util.UUID

data class Movie(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val shortDescription: String,
    val rating: Double,
    val imageUrl: String,
    val duration: Int,
    val genre: ArrayList<Genre> = arrayListOf()
) {

    enum class Genre(val value: String) {
        FANTASTIC("fantastic"),
        COMEDY("comedy"),
        HORROR("horror")
    }
}
