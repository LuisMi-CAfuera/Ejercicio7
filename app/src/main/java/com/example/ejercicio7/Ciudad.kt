package com.example.ejercicio7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityCiudadBinding

class Ciudad : AppCompatActivity() {
    private lateinit var binding: ActivityCiudadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCiudadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ciudad.setImageResource(R.drawable.ciudad)

        binding.Continuar.setOnClickListener{
            var intent = Intent(this@Ciudad, EntradaACiu::class.java)
            startActivity(intent)
        }

        binding.Volver.setOnClickListener{
            var intent = Intent(this@Ciudad, Ejercicio10::class.java)
            startActivity(intent)
        }
    }
}