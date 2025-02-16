package com.example.kopikenangan

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kopikenangan.databinding.ActivityKebijakanBinding

class KebijakanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKebijakanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKebijakanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
           finish()
        }

        val menuName = intent.getStringExtra("EXTRA_NAME")

        binding.title.text = menuName
    }
}