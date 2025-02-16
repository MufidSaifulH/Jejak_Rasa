package com.example.kopikenangan

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kopikenangan.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //recycle1
        val photo = intent.getIntExtra("EXTRA_PHOTO", 0)
        val name = intent.getStringExtra("EXTRA_NAME")
        val hargaCoret = intent.getStringExtra("EXTRA_HARGA_C")
        val hargaBaru = intent.getStringExtra("EXTRA_HARGA_B")

        Log.d("DetailActivity", "Photo: $photo, Name: $name, Harga Coret: $hargaCoret, Harga Baru: $hargaBaru")

        binding.imgDetail.setImageResource(photo)
        binding.tvDetailName.text = name
        binding.tvDetailHargaCoret.text = HtmlCompat.fromHtml(hargaCoret ?: "", HtmlCompat.FROM_HTML_MODE_LEGACY)
        binding.tvDetailHargaBaru.text = hargaBaru
        binding.tvKeranjang.text = hargaBaru


    }
}