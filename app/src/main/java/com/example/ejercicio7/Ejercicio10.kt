package com.example.ejercicio7

import android.annotation.SuppressLint
import android.content.Context
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
        val shared= getSharedPreferences("Personaje", Context.MODE_PRIVATE)
        val gson = Gson()
        var json = shared.getString("Personaje", "")
        val p = gson.fromJson(json, Personaje::class.java)

        binding.Valle.setImageResource(R.drawable.valle)
        binding.PesoMochila.isEnabled = false



        if(p.pesoMochila < 100){
            binding.PesoMochila.text = "Mochila: ${p.pesoMochila}/100"
            binding.PesoMochila.isEnabled = true
        }else{
            binding.PesoMochila.isEnabled = false
        }

        val editor = shared.edit()
        editor.clear()
        json = gson.toJson(p)
        editor.putString("Personaje", json)
        editor.apply()

        binding.Dado.setOnClickListener{
            aleatorio(p)
        }



    }

    @SuppressLint("SetTextI18n", "SuspiciousIndentation")
    fun aleatorio(Personaje: Personaje){
        var intent : Intent

        val aleatorio = (1..4).random()
        val gson = Gson()
        val json = gson.toJson(Personaje)


        when(aleatorio){

            1 ->{
                //Ir a la activity objeto
                binding.Explicacion.text = "Ha salido ${aleatorio} has encontrado un  Objeto"
                binding.BotonC.visibility = View.VISIBLE
                binding.BotonC.text = "Ir a Objeto"
                binding.BotonC.setOnClickListener {
                    intent = Intent(this@Ejercicio10, Objeto::class.java)
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
                    tipoEnemigo()
                }
            }
        }
    }

    fun tipoEnemigo(){
        val aleatorio = (1..10).random()

        if(aleatorio in 1..9){
            intent = Intent(this@Ejercicio10, Enemigo::class.java)
            startActivity(intent)
        }else if(aleatorio == 10){
            intent = Intent(this@Ejercicio10, Jefe::class.java)
            startActivity(intent)
        }


    }


}




