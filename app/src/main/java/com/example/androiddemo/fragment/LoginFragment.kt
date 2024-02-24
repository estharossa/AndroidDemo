package com.example.androiddemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androiddemo.R
import com.example.androiddemo.databinding.FragmentLoginBinding
import com.example.androiddemo.util.UserData


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            binding.submit.setOnClickListener {
                val login = loginEt.text.toString()
                val password = loginEt.text.toString()

                UserData(requireContext()).setAuthorized()

                val direction = LoginFragmentDirections.actionLoginFragmentToMovieListFragment()
                findNavController().navigate(direction)
            }
        }
    }
}