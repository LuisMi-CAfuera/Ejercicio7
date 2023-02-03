package com.example.ejercicio7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityMercaderBinding
import com.google.gson.Gson

class Mercader : AppCompatActivity() {
    private lateinit var binding: ActivityMercaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMercaderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val gson = Gson()
        val json = intent.getStringExtra("Personaje")
        val p = gson.fromJson(json, Personaje::class.java)


        binding.Mercader.setImageResource(R.drawable.mercader)



        binding.Comerciar.setOnClickListener{
            val intent = Intent(this@Mercader, Comerciar::class.java)
            val json2 = gson.toJson(p)
            intent.putExtra("Personaje", json2)
            startActivity(intent)
        }

        binding.Volver.setOnClickListener{
            val intent = Intent(this@Mercader, Ejercicio10::class.java)
            val json2 = gson.toJson(p)
            intent.putExtra("Personaje", json2)
            startActivity(intent)
        }

    }
}


