package com.example.androiddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.androiddemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val firstNumber = binding.firstNumber.text.toString().toInt()
            val secondNumber = binding.secondNumber.text.toString().toInt()
            val sum = firstNumber + secondNumber

            binding.result.isVisible = true
            binding.result.text = getString(R.string.result_fmt, sum)
        }

        binding.button2.setOnClickListener {
            binding.firstNumber.text.clear()
            binding.secondNumber.text.clear()
            binding.result.isVisible = false
        }
    }
}