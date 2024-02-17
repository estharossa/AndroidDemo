package com.example.androiddemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemo.databinding.ActivityMainBinding
import com.example.androiddemo.fragment.MovieListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieListFragment = MovieListFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, movieListFragment)
            .commit()
    }
}