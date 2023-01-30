package com.example.ejercicio7

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityMain3Binding

class Ejercicio9 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val Personaje = Personaje()
        Personaje.clase = intent.getStringExtra("CLASE").toString()
        Personaje.raza = intent.getStringExtra("RAZA").toString()
        Personaje.vida = 200
        Personaje.pesoMochila = 100
        Personaje.fuerza = (10..15).random()
        Personaje.defensa = (1..5).random()


        when(Personaje.clase){

            "Guerrero" ->{
                binding.clase.text = "Clase: ${Personaje.clase}"
                binding.Clase.setImageResource(R.drawable.guerrero2)
            }
            "Mago" ->{
                binding.clase.text = "Clase: ${Personaje.clase}"
                binding.Clase.setImageResource(R.drawable.mago)
            }
            "Ladron" ->{
                binding.clase.text = "Clase: ${Personaje.clase}"
                binding.Clase.setImageResource(R.drawable.ladron)
            }
            "Arquero" ->{
                binding.clase.text = "Clase: ${Personaje.clase}"
                binding.Clase.setImageResource(R.drawable.arquero)
            }
        }



        when(Personaje.raza){

            "Orco" ->{
                binding.raza.text = "Raza: ${Personaje.raza}"
                binding.Raza.setImageResource(R.drawable.orco)

            }
            "Elfo" ->{
                binding.raza.text = "Raza: ${Personaje.raza}"
                binding.Raza.setImageResource(R.drawable.elfo)

            }
            "Humano" ->{
                binding.raza.text = "Raza: ${Personaje.raza}"
                binding.Raza.setImageResource(R.drawable.humano)

            }
            "Enano" ->{
                binding.raza.text = "Raza: ${Personaje.raza}"
                binding.Raza.setImageResource(R.drawable.enano)

            }
        }
        Personaje.nombre = binding.Nombre.toString()

        binding.Fuerza.text = "Fuerza: ${Personaje.fuerza}"
        binding.Defensa.text = "Defensa: ${Personaje.defensa}"
        binding.Mochila.text= "Peso Mochila: ${Personaje.pesoMochila}"
        binding.Vida.text = "Vida: ${Personaje.vida}"
        binding.Monedero.text = "Monedero: 0$"


        binding.Volver.setOnClickListener{
            val intent = Intent(this@Ejercicio9, MainActivity::class.java)
            startActivity(intent)
        }

        binding.Seguir.setOnClickListener{
            val intent2 = Intent(this@Ejercicio9, Ejercicio10::class.java)
            intent2.putExtra("CLASE", Personaje.clase)
            intent2.putExtra("RAZA", Personaje.raza)
            intent2.putExtra("FUE", Personaje.fuerza)
            intent2.putExtra("DEF", Personaje.defensa)
            intent2.putExtra("MOCH", Personaje.pesoMochila)
            intent2.putExtra("VIDA", Personaje.vida)
            intent2.putExtra("NOMBRE", Personaje.nombre)
            startActivity(intent2)
        }









    }
}