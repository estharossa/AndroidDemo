package com.example.androiddemo.network

import com.example.androiddemo.model.MovieAPIResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {
    @GET("3/movie/popular?page=1&api_key=b82c172e7bf6660516881c6a1ed616dd")
    fun fetchMovieList(): Call<MovieAPIResponse>
}