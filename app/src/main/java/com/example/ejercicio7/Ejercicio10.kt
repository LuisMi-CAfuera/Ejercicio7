package com.example.ejercicio7

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio7.databinding.ActivityMain4Binding
import com.google.gson.Gson

class Ejercicio10 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding
    @SuppressLint("SetTextI18n", "CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val Personaje : Personaje = Personaje()
        Personaje.clase = intent.getStringExtra("CLASE").toString()
        Personaje.raza = intent.getStringExtra("RAZA").toString()
        Personaje.nombre = intent.getStringExtra("NOMBRE").toString()
        Personaje.pesoMochila = intent.getIntExtra("MOCH",0)
        Personaje.vida = intent.getIntExtra("VIDA",0)
        Personaje.fuerza = intent.getIntExtra("FUE",0)
        Personaje.defensa = intent.getIntExtra("DEF",0)
        binding.Valle.setImageResource(R.drawable.valle)
        binding.PesoMochila.isEnabled = false

        val mPrefs = getPreferences(MODE_PRIVATE)

        val prefs = mPrefs.edit()
        val gson = Gson()
        val json = gson.toJson(Personaje)
        prefs.putString("Personaje", json)
        prefs.apply()

        if(Personaje.pesoMochila < 100){
            binding.PesoMochila.text = "Mochila: ${Personaje.pesoMochila}/100"
            binding.PesoMochila.isEnabled = true
        }else{
            binding.PesoMochila.isEnabled = false
        }



        binding.Dado.setOnClickListener{
            aleatorio(Personaje)
        }



    }

    @SuppressLint("SetTextI18n", "SuspiciousIndentation")
    fun aleatorio(Personaje: Personaje){
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
                    intent.putExtra("Moch", Personaje.pesoMochila)

                    startActivity(intent)
                }
            }
            2 ->{
                //Ir a la activity Ciudad
                binding.Explicacion.text = "Ha salido ${aleatorio} has llegado a una Ciudad"
                binding.BotonC.visibility = View.VISIBLE
                binding.BotonC.text = "Ir a Ciudad"
                binding.BotonC.setOnClickListener {
                    intent = Intent(this@Ejercicio10, Ciudad::class.java)
                    startActivity(intent)
                }
            }
            3 ->{
                //Ir a la activity Mercader
                binding.Explicacion.text = "Ha salido ${aleatorio}, te has encontrado con un Mercader"
                binding.BotonC.visibility = View.VISIBLE
                binding.BotonC.text = "Hablar con Mercader"
                binding.BotonC.setOnClickListener {
                    intent = Intent(this@Ejercicio10, Mercader::class.java)
                    startActivity(intent)
                }
            }
            4 ->{
                //Ir a la activity Ladron
                binding.Explicacion.text = "Ha salido ${aleatorio}, te has encontrado con un Enemigo"
                binding.BotonC.visibility = View.VISIBLE
                binding.BotonC.text = "Pelear con Enemigo"
                binding.BotonC.setOnClickListener {
                    intent = Intent(this@Ejercicio10, Ladron::class.java)
                    startActivity(intent)
                }
            }
        }
    }


}




