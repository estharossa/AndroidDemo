package com.example.androiddemo.model

import com.example.androiddemo.R

object MovieDataSource {
    val movieList = arrayListOf<Movie>(
        Movie(
            title = "Avengers",
            shortDescription = "A movie about super heroes",
            rating = 8.5,
            imageUrl = "https://lumiere-a.akamaihd.net/v1/images/p_avengersendgame_19751_e14a0104.jpeg",
            duration = 120,
            genre = arrayListOf(Movie.Genre.HORROR, Movie.Genre.FANTASTIC)
        ),
        Movie(
            title = "Iron Man",
            shortDescription = "A movie about iron man",
            rating = 9.5,
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEtpe8ihPYpaSoqSjXf9IvK1fwtI4pUWrp5w&usqp=CAU",
            duration = 110,
            genre = arrayListOf(Movie.Genre.HORROR, Movie.Genre.FANTASTIC)
        ),
        Movie(
            title = "Thor",
            shortDescription = "A movie about god of Azgard",
            rating = 8.5,
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEtpe8ihPYpaSoqSjXf9IvK1fwtI4pUWrp5w&usqp=CAU",
            duration = 120,
            genre = arrayListOf(Movie.Genre.HORROR, Movie.Genre.FANTASTIC)
        ),

        )
}