package com.example.ejercicio7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityMain4Binding

class Ejercicio10 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        var Personaje : Personaje = Personaje()
        Personaje.clase = intent.getStringExtra("CLASE").toString()
        Personaje.raza = intent.getStringExtra("RAZA").toString()
        Personaje.nombre = intent.getStringExtra("NOMBRE").toString()
        Personaje.pesoMochila = intent.getIntExtra("MOCH",0)
        Personaje.vida = intent.getIntExtra("VIDA",0)
        Personaje.fuerza = intent.getIntExtra("FUE",0)
        Personaje.defensa = intent.getIntExtra("DEF",0)




    }
}