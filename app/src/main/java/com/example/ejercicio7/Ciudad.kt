package com.example.ejercicio7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityCiudadBinding
import com.google.gson.Gson

class Ciudad : AppCompatActivity() {
    private lateinit var binding: ActivityCiudadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCiudadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val gson = Gson()
        val json = intent.getStringExtra("Personaje")
        val p = gson.fromJson(json, Personaje::class.java)

        binding.ciudad.setImageResource(R.drawable.ciudad)




        binding.Continuar.setOnClickListener{
            val intent = Intent(this@Ciudad, EntradaACiu::class.java)
            val json2 = gson.toJson(p)
            intent.putExtra("Personaje", json2)
            startActivity(intent)
        }

        binding.Volver.setOnClickListener{
            val intent = Intent(this@Ciudad, Ejercicio10::class.java)
            val json2 = gson.toJson(p)
            intent.putExtra("Personaje", json2)
            startActivity(intent)
        }
    }
}