package com.example.kopikenangan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kopikenangan.databinding.ActivityTentangBinding

class KetentuanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTentangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTentangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
          finish()
        }
        val menuName = intent.getStringExtra("EXTRA_NAME")

        binding.title.text = menuName
    }
}