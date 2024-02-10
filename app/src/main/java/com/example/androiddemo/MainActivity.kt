package com.example.androiddemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemo.adapter.MovieAdapter
import com.example.androiddemo.databinding.ActivityMainBinding
import com.example.androiddemo.model.Movie
import com.example.androiddemo.model.MovieDataSource

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var adapter: MovieAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MovieAdapter(
            onMovieClick = {
                handleMovieClick(it)
            },
            onMovieRemoved = {
                handleMovieRemoval(it)
            }
        )

        adapter = MovieAdapter(
            onMovieClick = {
                handleMovieClick(it)
            },
            onMovieRemoved = {
                handleMovieRemoval(it)
            }
        )

        binding.recyclerView.adapter = adapter

        adapter?.setData(MovieDataSource.movieList)
    }

    private fun handleMovieClick(movie: Movie) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(SecondActivity.KEY_RESULT, movie.title)
        startActivity(intent)
    }

    private fun handleMovieRemoval(movie: Movie) {
        val movieList = MovieDataSource.movieList
        movieList.remove(movie)

        adapter?.setData(movieList)
    }
}