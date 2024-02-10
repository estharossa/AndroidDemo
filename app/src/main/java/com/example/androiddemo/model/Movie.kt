package com.example.androiddemo.model

import java.util.UUID

data class Movie(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val shortDescription: String,
    val rating: Double,
    val imageRes: Int,
    val duration: Int,
    val genre: String
)
