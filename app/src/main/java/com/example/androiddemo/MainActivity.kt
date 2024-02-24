package com.example.androiddemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.androiddemo.databinding.ActivityMainBinding
import com.example.androiddemo.fragment.MovieListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        navGraph.setStartDestination(R.id.movie_list_fragment)
//        when {
//            UserData(this).isAuthorized -> {
//                navGraph.setStartDestination(R.id.movieListFragment)
//            }
//
////            !UserData.isAuthorized -> {
////                navGraph.setStartDestination(R.id.signFlowFragment)
////            }
//        }
        navController.graph = navGraph
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}