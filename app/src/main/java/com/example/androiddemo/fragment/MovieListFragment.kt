package com.example.androiddemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androiddemo.R
import com.example.androiddemo.adapter.MovieAdapter
import com.example.androiddemo.databinding.FragmentMovieListBinding
import com.example.androiddemo.model.Movie
import com.example.androiddemo.model.MovieDataSource

class MovieListFragment : Fragment() {

    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MovieListFragment()
    }

    private var adapter: MovieAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        requireActivity().supportFragmentManager.setFragmentResultListener(
            "MovieTitleResult",
            viewLifecycleOwner
        ) { requestKey, bundle ->
            val result = bundle.getString("bundleKey")
            MovieDataSource.movieList.add(
                Movie(
                    title = result!!,
                    shortDescription = "A movie about super heroes",
                    rating = 8.5,
                    imageUrl = "https://lumiere-a.akamaihd.net/v1/images/p_avengersendgame_19751_e14a0104.jpeg",
                    duration = 120,
                    genre = arrayListOf(Movie.Genre.HORROR, Movie.Genre.FANTASTIC)
                )
            )

            adapter?.setData(MovieDataSource.movieList)
        }
    }


    private fun handleMovieClick(movie: Movie) {
        /**
         * transition to movie details using activity
         */
//        val intent = Intent(requireContext(), SecondActivity::class.java)
//        intent.putExtra(SecondActivity.KEY_RESULT, movie.title)
//        startActivity(intent)

        /**
         * transition to movie details using fragment
         */

        val movieDetailsFragment = MovieDetailsFragment.newInstance(movie.title)

        requireActivity().supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container, movieDetailsFragment)
            .commit()
    }

    private fun handleMovieRemoval(movie: Movie) {
        val movieList = MovieDataSource.movieList
        movieList.remove(movie)

        adapter?.setData(movieList)
    }

}