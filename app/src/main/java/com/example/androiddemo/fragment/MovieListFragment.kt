package com.example.androiddemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androiddemo.adapter.MovieAdapter
import com.example.androiddemo.databinding.FragmentMovieListBinding
import com.example.androiddemo.model.Movie
import com.example.androiddemo.model.MovieDataSource
import com.example.androiddemo.model.Person
import com.example.androiddemo.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListFragment : Fragment() {

    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!

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

        binding.editText.addTextChangedListener {
            val searchQuery = it.toString()

            if (searchQuery.isEmpty()) {
                adapter?.setData(MovieDataSource.movieList)
            } else {
                val list = MovieDataSource.movieList.filter {
                    it.title.contains(searchQuery)
                }

                adapter?.setData(ArrayList(list))
            }
        }

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

        val client = ApiClient.instance
        val response = client.fetchPersonList()

        response.enqueue(object : Callback<List<Person>> {
            override fun onResponse(call: Call<List<Person>>, response: Response<List<Person>>) {
                println("HttpResponse: ${response.body()}")

                /**
                 * example
                 */
//                val list = response.body()
//
//                if (list != null) {
//                    pizzaAdapter.setData(list)
//                }
            }

            override fun onFailure(call: Call<List<Person>>, t: Throwable) {
                println("HttpResponse: ${t.message}")
            }
        })

        println("HttpResponse: 2 + 2 = 4")
    }


    private fun handleMovieClick(movie: Movie) {
        /**
         * transition to movie details using activity
         */
//        val intent = Intent(requireContext(), SecondActivity::class.java)
//        intent.putExtra(SecondActivity.KEY_RESULT, movie.title)
//        startActivity(intent)

        /**
         * transition to movie details using fragment manager
         */

//        val movieDetailsFragment = MovieDetailsFragment.newInstance(movie.title)
//
//        requireActivity().supportFragmentManager
//            .beginTransaction()
//            .addToBackStack(null)
//            .replace(R.id.fragment_container, movieDetailsFragment)
//            .commit()

        /**
         * transition to movie details using Jetpack Navigation
         */
        val direction =
            MovieListFragmentDirections.actionMovieListFragmentToMovieDetailsFragment(movie.title)
        findNavController().navigate(direction)
    }

    private fun handleMovieRemoval(movie: Movie) {
        val movieList = MovieDataSource.movieList
        movieList.remove(movie)

        adapter?.setData(movieList)
    }

}