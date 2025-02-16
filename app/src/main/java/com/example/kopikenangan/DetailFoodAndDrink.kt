package com.example.kopikenangan

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kopikenangan.databinding.ActivityDetailFoodAndDrinkBinding

class DetailFoodAndDrink : AppCompatActivity() {

    private lateinit var binding : ActivityDetailFoodAndDrinkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFoodAndDrinkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val foto = intent.getIntExtra("EXTRA_PHOTO", 0)
        val nama = intent.getStringExtra("EXTRA_NAME")
        val harga = intent.getStringExtra("EXTRA_HARGA_B")

        binding.imgDetail.setImageResource(foto)
        binding.tvDetailName.text = nama
        binding.tvDetailHargaBaru.text = harga
        binding.tvKeranjang.text =harga

    }
}