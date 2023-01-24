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
        var Personaje = Personaje()
        setContentView(binding.root)

        binding.Guerrero.setOnClickListener {
            binding.imagenes.setImageResource(R.drawable.guerrero2)
            Personaje.clase = "Guerrero"
        }

        binding.Mago.setOnClickListener {
            binding.imagenes.setImageResource(R.drawable.mago)
            Personaje.clase = "Mago"
        }

        binding.ladron.setOnClickListener {
            binding.imagenes.setImageResource(R.drawable.ladron)
            Personaje.clase = "Ladron"
        }

        binding.Arquero.setOnClickListener {
            binding.imagenes.setImageResource(R.drawable.arquero)
            Personaje.clase = "Arquero"
        }

        binding.Aceptar.setOnClickListener {
            //cambiar de activity
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("CLASE", Personaje.clase)
            startActivity(intent)
        }
    }
}


