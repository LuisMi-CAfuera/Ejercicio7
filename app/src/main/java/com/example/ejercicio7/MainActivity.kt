package com.example.ejercicio7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Guerrero.setOnClickListener {
            binding.imagenes.setImageResource(R.drawable.guerrero2)
        }

        binding.Mago.setOnClickListener {
            binding.imagenes.setImageResource(R.drawable.mago)
        }

        binding.ladron.setOnClickListener {
            binding.imagenes.setImageResource(R.drawable.ladron)
        }

        binding.Arquero.setOnClickListener {
            binding.imagenes.setImageResource(R.drawable.arquero)
        }

        binding.Aceptar.setOnClickListener {
            //cambiar de activity
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}