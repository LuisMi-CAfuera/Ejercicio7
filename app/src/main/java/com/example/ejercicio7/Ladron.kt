package com.example.ejercicio7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityLadronBinding
import com.google.gson.Gson

class Ladron : AppCompatActivity() {
    private lateinit var binding: ActivityLadronBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLadronBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gson = Gson()
        val json = intent.getStringExtra("Personaje")
        val p = gson.fromJson(json, Personaje::class.java)

        binding.Ladron2.setImageResource(R.drawable.enemigo1)




        binding.Luchar.setOnClickListener{
            val intent = Intent(this@Ladron, Lucha::class.java)
            val json2 = gson.toJson(p)
            intent.putExtra("Personaje", json2)
            startActivity(intent)
        }

        binding.Huir.setOnClickListener{
            val intent = Intent(this@Ladron, Ejercicio10::class.java)
            val json2 = gson.toJson(p)
            intent.putExtra("Personaje", json2)
            startActivity(intent)
        }
    }
}