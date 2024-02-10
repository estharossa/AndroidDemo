package com.example.androiddemo.model

import com.example.androiddemo.R

object MovieDataSource {
    val movieList = arrayListOf<Movie>(
        Movie(
            title = "Avengers",
            shortDescription = "A movie about super heroes",
            rating = 8.5,
            imageRes = R.drawable.baseline_connected_tv_24,
            duration = 120,
            genre = arrayListOf(Movie.Genre.HORROR, Movie.Genre.FANTASTIC)
        ),
        Movie(
            title = "Iron Man",
            shortDescription = "A movie about iron man",
            rating = 9.5,
            imageRes = R.drawable.baseline_connected_tv_24,
            duration = 110,
            genre = arrayListOf(Movie.Genre.HORROR, Movie.Genre.FANTASTIC)
        ),
        Movie(
            title = "Thor",
            shortDescription = "A movie about god of Azgard",
            rating = 8.5,
            imageRes = R.drawable.baseline_connected_tv_24,
            duration = 120,
            genre = arrayListOf(Movie.Genre.HORROR, Movie.Genre.FANTASTIC)
        ),

    )
}