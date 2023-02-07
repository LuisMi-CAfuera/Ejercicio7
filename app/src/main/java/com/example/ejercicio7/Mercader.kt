package com.example.ejercicio7

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ejercicio7.databinding.ActivityMercaderBinding
import com.google.gson.Gson

class Mercader : AppCompatActivity() {
    private lateinit var binding: ActivityMercaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMercaderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val shared= getSharedPreferences("Personaje", Context.MODE_PRIVATE)
        val gson = Gson()
        var json = shared.getString("Personaje", "")
        val p = gson.fromJson(json, Personaje::class.java)






        binding.Comerciar.setOnClickListener{
            binding.Comerciar.visibility = View.INVISIBLE
            binding.Comprar.visibility = View.VISIBLE
            binding.Vender.visibility = View.VISIBLE
            binding.Cancelar.visibility = View.VISIBLE
            binding.Volver.visibility = View.INVISIBLE
        }

        binding.Comprar.setOnClickListener{
            binding.Mercader.setImageResource()
        }

        binding.Volver.setOnClickListener{
            val intent = Intent(this@Mercader, Ejercicio10::class.java)
            val edit = shared.edit()
            edit.clear()
            json = gson.toJson(p)
            edit.putString("Personaje", json)
            edit.apply()
            startActivity(intent)
        }

    }
}


