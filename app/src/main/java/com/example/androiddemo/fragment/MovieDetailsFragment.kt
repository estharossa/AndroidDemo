package com.example.androiddemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.example.androiddemo.databinding.FragmentMovieDetailsBinding


class MovieDetailsFragment : Fragment() {

    companion object {
        private const val KEY_MOVIE_TITLE = "movieTitle"

        fun newInstance(movieTitle: String) = MovieDetailsFragment().apply {
            arguments = bundleOf(KEY_MOVIE_TITLE to movieTitle)
        }
    }

    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    private val title: String? by lazy {
        requireArguments().getString(KEY_MOVIE_TITLE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.movieTitle.text = title

        binding.button.setOnClickListener {
            val movieTitle = binding.editText.text.toString()
            setFragmentResult("MovieTitleResult", bundleOf("bundleKey" to movieTitle))
            requireActivity().onBackPressed()
        }
    }
}