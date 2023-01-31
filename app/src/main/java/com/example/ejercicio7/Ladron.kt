package com.example.ejercicio7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityLadronBinding

class Ladron : AppCompatActivity() {
    private lateinit var binding: ActivityLadronBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLadronBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Ladron2.setImageResource(R.drawable.enemigo1)



        binding.Luchar.setOnClickListener{
            var intent = Intent(this@Ladron, Lucha::class.java)
            startActivity(intent)
        }

        binding.Huir.setOnClickListener{
            var intent = Intent(this@Ladron, Ejercicio10::class.java)
            startActivity(intent)
        }
    }
}