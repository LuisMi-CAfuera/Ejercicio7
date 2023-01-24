package com.example.ejercicio7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        var Personaje = Personaje()
        Personaje = Personaje.inicializacion(Personaje)
        Personaje.clase = intent.getStringExtra("CLASE").toString()
        Personaje.raza = intent.getStringExtra("RAZA").toString()



    }
}