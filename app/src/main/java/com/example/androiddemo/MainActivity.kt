package com.example.androiddemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import com.example.androiddemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sumBtn.setOnClickListener {
            val firstNumber = binding.firstNumber.text.toString().toInt()
            val secondNumber = binding.secondNumber.text.toString().toInt()
            val calculator = Calculator(firstNumber, secondNumber)

            binding.result.isVisible = true
            binding.result.text = getString(R.string.result_fmt, calculator.sum())
        }

        binding.subtractBtn.setOnClickListener {
            val firstNumber = binding.firstNumber.text.toString().toInt()
            val secondNumber = binding.secondNumber.text.toString().toInt()
            val calculator = Calculator(firstNumber, secondNumber)

            binding.result.isVisible = true
            binding.result.text = getString(R.string.result_fmt, calculator.subtraction())
        }

        binding.multiplyBtn.setOnClickListener {
            val firstNumber = binding.firstNumber.text.toString().toInt()
            val secondNumber = binding.secondNumber.text.toString().toInt()
            val calculator = Calculator(firstNumber, secondNumber)

            binding.result.isVisible = true
            binding.result.text = getString(R.string.result_fmt, calculator.multiplication())
        }

        binding.button2.setOnClickListener {
            binding.firstNumber.text.clear()
            binding.secondNumber.text.clear()
            binding.result.isVisible = false
        }

        binding.changeActivity.setOnClickListener {
            val result = binding.result.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(SecondActivity.KEY_RESULT, result)
            startActivity(intent)
        }
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }
}