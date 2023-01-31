package com.example.ejercicio7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityObjetoBinding

class Objeto : AppCompatActivity() {
    private lateinit var binding: ActivityObjetoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObjetoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.Objeto.setImageResource(R.drawable.objeto)

        binding.Volver.setOnClickListener{
            var intent = Intent(this@Objeto, Ejercicio10::class.java)
            startActivity(intent)
        }

        binding.Recoger.setOnClickListener{
            var intent = Intent(this@Objeto, ObjetoB::class.java)
            startActivity(intent)
        }
    }
}