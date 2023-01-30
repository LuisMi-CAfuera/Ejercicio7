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
        var clase=""



        binding.Guerrero.setOnClickListener {
            binding.imagenes.setImageResource(R.drawable.guerrero2)
            clase = "Guerrero"
        }

        binding.Mago.setOnClickListener {
            binding.imagenes.setImageResource(R.drawable.mago)
            clase = "Mago"
        }

        binding.ladron.setOnClickListener {
            binding.imagenes.setImageResource(R.drawable.ladron)
            clase = "Ladron"
        }

        binding.Arquero.setOnClickListener {
            binding.imagenes.setImageResource(R.drawable.arquero)
            clase = "Arquero"
        }

        binding.Aceptar.setOnClickListener {
            //cambiar de activity
            val intent = Intent(this@MainActivity, Ejercicio8::class.java)
            intent.putExtra("CLASE", clase)
            startActivity(intent)
        }
    }
}


