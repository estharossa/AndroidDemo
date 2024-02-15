package com.example.androiddemo.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemo.databinding.ItemMovieBinding
import com.example.androiddemo.model.Movie
import com.example.androiddemo.model.MovieItemCallback

class MovieAdapter(
    private val onMovieClick: (Movie) -> Unit,
    private val onMovieRemoved: (Movie) -> Unit,
    private val onChangeFavouriteState: (Movie) -> Unit
) : ListAdapter<Movie, MovieAdapter.ViewHolder>(MovieItemCallback()) {

    companion object {
        private const val MOVIE_ADAPTER_TAG = "MovieAdapter"
    }

    /**
     * метод, который будет создавать view для каждого объекта
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    /**
     * для вызова метода из ViewHolder'a
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(MOVIE_ADAPTER_TAG, "onBindViewHolder: $position")
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            with(binding) {
                movieImage.setImageResource(movie.imageRes)
                movieTitle.text = movie.title
                movieDescription.text = movie.shortDescription
                movieRating.text = "${movie.rating}/5"
                movieGenre.text = movie.genre.first().value

                root.setOnClickListener {
                    onMovieClick(movie)
                }

                removeMovie.setOnClickListener {
                    onMovieRemoved(movie)
                }

                favourite.setOnClickListener {
                    onChangeFavouriteState(movie)
                }

                if (movie.isFavourite) {
                    favourite.imageTintList = ColorStateList.valueOf(Color.YELLOW)
                } else {
                    favourite.imageTintList = ColorStateList.valueOf(Color.BLACK)
                }
            }
        }
    }
}