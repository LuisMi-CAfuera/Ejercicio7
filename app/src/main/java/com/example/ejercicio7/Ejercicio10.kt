package com.example.ejercicio7

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        binding.Valle.setImageResource(R.drawable.valle)



        binding.Dado.setOnClickListener{
            aleatorio()
        }





    }

    @SuppressLint("SetTextI18n", "SuspiciousIndentation")
    fun aleatorio(){
      var intent : Intent

      val aleatorio = (1..4).random()

        when(aleatorio){

            1 ->{
                //Ir a la activity objeto
                binding.Explicacion.text = "Ha salido ${aleatorio} has encontrado un  Objeto"
                binding.BotonC.visibility = View.VISIBLE
                binding.BotonC.text = "Ir a Objeto"
                binding.BotonC.setOnClickListener {
                    intent = Intent(this@Ejercicio10, Objeto::class.java)
                }
            }
            2 ->{
                //Ir a la activity Ciudad
                binding.Explicacion.text = "Ha salido ${aleatorio} has llegado a una Ciudad"
                binding.BotonC.visibility = View.VISIBLE
                binding.BotonC.text = "Ir a Ciudad"
                binding.BotonC.setOnClickListener {
                    intent = Intent(this@Ejercicio10, Ciudad::class.java)
                }
            }
            3 ->{
                //Ir a la activity Mercader
                binding.Explicacion.text = "Ha salido ${aleatorio}, te has encontrado con un Mercader"
                binding.BotonC.visibility = View.VISIBLE
                binding.BotonC.text = "Hablar con Mercader"
                binding.BotonC.setOnClickListener {
                    intent = Intent(this@Ejercicio10, Mercader::class.java)
                }
            }
            4 ->{
                //Ir a la activity Ladron
                binding.Explicacion.text = "Ha salido ${aleatorio}, te has encontrado con un Ladron"
                binding.BotonC.visibility = View.VISIBLE
                binding.BotonC.text = "Pelear con Ladron"
                binding.BotonC.setOnClickListener {
                    intent = Intent(this@Ejercicio10, Ladron::class.java)
                }
            }
        }
    }
}