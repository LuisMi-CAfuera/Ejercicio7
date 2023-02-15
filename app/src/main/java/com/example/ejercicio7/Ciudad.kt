package com.example.ejercicio7

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityCiudadBinding
import com.google.gson.Gson

class Ciudad : AppCompatActivity() {
    private lateinit var binding: ActivityCiudadBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCiudadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val shared= getSharedPreferences("Personaje", Context.MODE_PRIVATE)
        val gson = Gson()
        var json = shared.getString("Personaje", "")
        val p = gson.fromJson(json, Personaje::class.java)
        var cont = intent.getIntExtra("cont", 0)
        var intent = Intent(this@Ciudad, Ciudad::class.java)


        if(cont > 0){
            binding.Contador.text = "LLevas "+cont+" batallas ganadas \n necesitas 5 para ganar"
        }


        binding.Entrar.setOnClickListener{
            val aleatorio = (1..3).random()
            val al2 = (1..10).random()
            var tipo = ""
            when(aleatorio){
                1 -> intent = Intent(this@Ciudad, ObjetoCiudad::class.java)
                2 -> intent = Intent(this@Ciudad, EnemigoCiudad::class.java)
                3 -> intent = Intent(this@Ciudad, EnemigoCiudad::class.java)
            }

            if(al2 == 1){
                intent.putExtra("tipo", "Boss")
            }else if(al2 in 2..10){
                intent.putExtra("tipo", "Normal")
            }
            startActivity(intent)
        }


        binding.Continuar.isEnabled = cont == 5

        binding.Continuar.setOnClickListener{
            val intent = Intent(this@Ciudad, Ejercicio10::class.java)
            val editor = shared.edit()
            editor.clear()
            json = gson.toJson(p)
            editor.putString("Personaje", json)
            editor.apply()
            startActivity(intent)
        }


    }



}