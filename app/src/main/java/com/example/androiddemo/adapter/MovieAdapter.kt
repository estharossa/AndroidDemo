package com.example.androiddemo.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androiddemo.R
import com.example.androiddemo.databinding.ItemMovieBinding
import com.example.androiddemo.model.Movie

class MovieAdapter(
    private val onMovieClick: (Movie) -> Unit,
    private val onMovieRemoved: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    companion object {
        private const val MOVIE_ADAPTER_TAG = "MovieAdapter"
    }

    private val movieList: ArrayList<Movie> = ArrayList()

    fun setData(movies: ArrayList<Movie>) {
        movieList.clear()
        movieList.addAll(movies)

        /**
         * метод для обновления списка элементов
         */
        notifyDataSetChanged()
    }

    /**
     * метод, который будет создавать view для каждого объекта
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d(MOVIE_ADAPTER_TAG, "onCreateViewHolder")
        return ViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    /**
     * метод, для определения количесвта элементов списка
     */
    override fun getItemCount() = movieList.size

    /**
     * для вызова метода из ViewHolder'a
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(MOVIE_ADAPTER_TAG, "onBindViewHolder: $position")
        holder.bind(movieList[position])
    }

    inner class ViewHolder(
        private val binding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            with(binding) {

                Glide
                    .with(root.context)
                    .load(movie.imageUrl)
                    .placeholder(R.drawable.baseline_connected_tv_24)
                    .into(movieImage)

//                movieImage.setImageResource(movie.imageRes)
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
            }
        }
    }
}