package com.example.ejercicio7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var Personaje: Personaje
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        Personaje.clase = intent.getStringExtra("Personaje").toString()



        binding.Orco.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.orco)
            Personaje.raza = "Orco"
        }
        binding.Elfo.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.elfo)
            Personaje.raza = "Elfo"
        }
        binding.Humano.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.humano)
            Personaje.raza = "Humano"
        }
        binding.Enano.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.enano)
            Personaje.raza = "Enano"
        }

            binding.Aceptar.setOnClickListener{
            val intent = Intent(this@MainActivity2, MainActivity3::class.java)
            intent.putExtra("Personaje", Personaje.raza)
            startActivity(intent)
        }

    }
}