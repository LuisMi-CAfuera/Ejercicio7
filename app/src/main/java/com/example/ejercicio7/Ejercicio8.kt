package com.example.ejercicio7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityMain2Binding
import com.google.gson.Gson


class Ejercicio8 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val gson = Gson()
        val json = intent.getStringExtra("Personaje")
        val p = gson.fromJson(json, Personaje::class.java)




        binding.Orco.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.orco)
            p.raza = "Orco"
        }
        binding.Elfo.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.elfo)
            p.raza = "Elfo"
        }
        binding.Humano.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.humano)
            p.raza = "Humano"
        }
        binding.Enano.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.enano)
            p.raza = "Enano"
        }

        binding.Aceptar.setOnClickListener{
            val intent = Intent(this@Ejercicio8, Ejercicio9::class.java)
            val json2 = gson.toJson(p)
            intent.putExtra("Personaje", json2)
            startActivity(intent)
        }

    }
}