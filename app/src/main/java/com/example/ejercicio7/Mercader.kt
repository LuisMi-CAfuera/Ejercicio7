package com.example.ejercicio7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityMercaderBinding

class Mercader : AppCompatActivity() {
    private lateinit var binding: ActivityMercaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMercaderBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.Mercader.setImageResource(R.drawable.mercader)




        binding.Comerciar.setOnClickListener{
            var intent = Intent(this@Mercader, Comerciar::class.java)
            startActivity(intent)
        }

        binding.Volver.setOnClickListener{
            var intent = Intent(this@Mercader, Ejercicio10::class.java)
            startActivity(intent)
        }

    }
}


