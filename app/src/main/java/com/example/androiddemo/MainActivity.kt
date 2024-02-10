package com.example.androiddemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemo.adapter.MovieAdapter
import com.example.androiddemo.databinding.ActivityMainBinding
import com.example.androiddemo.model.MovieDataSource

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MovieAdapter()

        binding.recyclerView.adapter = adapter

        adapter.setData(MovieDataSource.movieList)
    }
}