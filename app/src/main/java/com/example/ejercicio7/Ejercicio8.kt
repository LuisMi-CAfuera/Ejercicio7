package com.example.ejercicio7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityMain2Binding


class Ejercicio8 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        var raza = ""
        var clase = intent.getStringExtra("CLASE").toString()




        binding.Orco.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.orco)
            raza = "Orco"
        }
        binding.Elfo.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.elfo)
            raza = "Elfo"
        }
        binding.Humano.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.humano)
            raza = "Humano"
        }
        binding.Enano.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.enano)
            raza = "Enano"
        }

            binding.Aceptar.setOnClickListener{
            val intent = Intent(this@Ejercicio8, Ejercicio9::class.java)
            intent.putExtra("RAZA", raza)
            intent.putExtra("CLASE", clase)
            startActivity(intent)
            }

    }
}