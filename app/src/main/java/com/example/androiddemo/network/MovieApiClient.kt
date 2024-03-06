package com.example.androiddemo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object MovieApiClient {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val instance = retrofit.create(MovieService::class.java)
}