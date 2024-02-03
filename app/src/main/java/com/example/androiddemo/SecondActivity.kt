package com.example.androiddemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.example.androiddemo.databinding.ActivityMainBinding
import com.example.androiddemo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    companion object {
        const val KEY_RESULT = "KeyResult"
    }

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getStringExtra(KEY_RESULT)

        binding.resultTextView.text = result

        binding.intentButton.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.setData(Uri.parse("tel:+770112312322"))
//            startActivity(intent)

            val pickImg = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivity(pickImg)
        }
    }
}