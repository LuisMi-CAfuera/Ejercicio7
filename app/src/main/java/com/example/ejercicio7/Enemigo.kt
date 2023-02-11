package com.example.ejercicio7

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityEnemigoBinding
import com.google.gson.Gson

class Enemigo : AppCompatActivity() {
    private lateinit var binding: ActivityEnemigoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnemigoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val shared = getSharedPreferences("Personaje", Context.MODE_PRIVATE)
        val gson = Gson()
        var json = shared.getString("Personaje", "")
        val p = gson.fromJson(json, Personaje::class.java)
        val enemigo = Personaje()
        enemigo.vida = 100








    }

    fun atacarEnemigo(personaje: Personaje, enemigo: Personaje){
        val aleatorio = (1..6).random()
        if(aleatorio in 4..6){

        }
    }
}