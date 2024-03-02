package com.example.androiddemo.network

import com.example.androiddemo.model.Person
import retrofit2.Call
import retrofit2.http.GET

interface PersonService {
    @GET("person_list")
    fun fetchPersonList(): Call<List<Person>>
}