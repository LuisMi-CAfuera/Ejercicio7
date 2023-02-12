package com.example.ejercicio7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityMuerteBinding

class Muerte : AppCompatActivity() {
    private lateinit var binding: ActivityMuerteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMuerteBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.Volver.setOnClickListener {
            val intent = Intent(this@Muerte, MainActivity::class.java)
            startActivity(intent)
        }


    }
}