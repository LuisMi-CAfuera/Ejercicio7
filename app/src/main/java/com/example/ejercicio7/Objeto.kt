package com.example.ejercicio7

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityObjetoBinding

class Objeto : AppCompatActivity() {
    private lateinit var binding: ActivityObjetoBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObjetoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var p= Personaje()
        p.pesoMochila= intent.getIntExtra("Moch", 0)
        //Un objeto objetos inicializado con el peso y el valor y la vida
        var objeto = Objetos((1..5).random(), (1..10).random(), (1..20).random())



        binding.Objeto.setImageResource(R.drawable.objeto)


        binding.TextoObjeto.setText("Peso Maximo de la mochila: "+p.pesoMochila+"kg\n" +
                                    "Peso del objeto: "+objeto.peso +"kg\n"+
                                    "Valor del objeto:"+objeto.valor+"kg\n"+
                                    "Si coges este objeto, tu mochila solo podra llevar:"+ (p.pesoMochila-objeto.peso)+"kg\n")




        binding.Volver.setOnClickListener{
            var intent = Intent(this@Objeto, Ejercicio10::class.java)
            startActivity(intent)
        }

        binding.Recoger.setOnClickListener{
            var intent = Intent(this@Objeto, Ejercicio10::class.java)
            intent.putExtra("MOCH", p.pesoMochila-objeto.peso)
            startActivity(intent)
        }

    }
}