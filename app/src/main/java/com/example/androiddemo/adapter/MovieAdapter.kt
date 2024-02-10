package com.example.androiddemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemo.databinding.ItemMovieBinding
import com.example.androiddemo.model.Movie

class MovieAdapter(
    private val onMovieClick: (Movie) -> Unit,
    private val onMovieRemoved: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

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
        holder.bind(movieList[position])
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
            }
        }
    }
}