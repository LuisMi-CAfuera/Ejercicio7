package com.example.ejercicio7

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityObjetoBinding
import com.google.gson.Gson

class Objeto : AppCompatActivity() {
    private lateinit var binding: ActivityObjetoBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObjetoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val gson = Gson()
        val json = intent.getStringExtra("Personaje")
        val p = gson.fromJson(json, Personaje::class.java)
        //Un objeto objetos inicializado con el peso y el valor y la vida
        val objeto = Objetos((1..5).random(), (1..10).random(), (1..20).random())





        binding.Objeto.setImageResource(R.drawable.objeto)


        binding.TextoObjeto.setText("Peso Maximo de la mochila: "+p.pesoMochila+"kg\n" +
                                    "Peso del objeto: "+objeto.peso +"kg\n"+
                                    "Valor del objeto: "+objeto.valor+"€\n"+
                                    "Vida del objeto: "+objeto.vida+"\n"+
                                    "Si coges este objeto, tu mochila solo podra llevar:"+ (p.pesoMochila-objeto.peso)+"kg\n")





        binding.Volver.setOnClickListener{
            val intent = Intent(this@Objeto, Ejercicio10::class.java)
            val json2 = gson.toJson(p)
            intent.putExtra("Personaje", json2)
            startActivity(intent)
        }

        binding.Recoger.setOnClickListener{
            val intent = Intent(this@Objeto, Ejercicio10::class.java)
            p.pesoMochila -= objeto.peso
            p.mochila.add(objeto)
            val json2 = gson.toJson(p)
            intent.putExtra("Personaje", json2)
            startActivity(intent)
        }

    }
}