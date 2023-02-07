package com.example.ejercicio7

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ejercicio7.databinding.ActivityMercaderBinding
import com.google.gson.Gson

class Mercader : AppCompatActivity() {
    private lateinit var binding: ActivityMercaderBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMercaderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val shared= getSharedPreferences("Personaje", Context.MODE_PRIVATE)
        val gson = Gson()
        var json = shared.getString("Personaje", "")
        val p = gson.fromJson(json, Personaje::class.java)
        var espada = Objetos("Espada",14, 125, 200)
        var escudo = Objetos("Escudo", 10, 100, 250)
        var armadura = Objetos("Armadura", 20, 150, 300)
        var pocion = Objetos("Pocion", 2, 50, 100)
        var cantidad = 0



        binding.Comerciar.setOnClickListener{
            binding.Comerciar.visibility = View.INVISIBLE
            binding.Comprar.visibility = View.VISIBLE
            binding.Vender.visibility = View.VISIBLE
            binding.Cancelar.visibility = View.VISIBLE
            binding.Volver.visibility = View.INVISIBLE
        }

        binding.Comprar.setOnClickListener{
            binding.spinner.visibility = View.VISIBLE
            binding.Comprar.visibility = View.INVISIBLE
            binding.Vender.visibility = View.INVISIBLE
            binding.Cancelar.visibility = View.INVISIBLE
            binding.mas.visibility = View.VISIBLE
            binding.menos.visibility = View.VISIBLE
            binding.CantidadYPrecio.visibility = View.VISIBLE
            binding.CantidadYPrecio.text = "Cantidad: ${cantidad} Precio: 0"
        }

        binding.mas.setOnClickListener{
            cantidad++
        }
        binding.menos.setOnClickListener{
            cantidad--
        }
        when(binding.spinner.selectedItem.toString()){

            "Espada" -> {
                binding.Mercader.setImageResource(R.drawable.espada)
                binding.CantidadYPrecio.text = "Cantidad: ${cantidad} Precio: ${espada.valor*cantidad}"
            }

            "Escudo" -> {
                binding.Mercader.setImageResource(R.drawable.escudo)
                binding.CantidadYPrecio.text = "Cantidad: ${cantidad} Precio: ${escudo.valor*cantidad}"
            }

            "Armadura" -> {
                binding.Mercader.setImageResource(R.drawable.armadura)
                binding.CantidadYPrecio.text = "Cantidad: ${cantidad} Precio: ${armadura.valor*cantidad}"
            }

            "Pocion" -> {
                binding.Mercader.setImageResource(R.drawable.pocion)
                binding.CantidadYPrecio.text = "Cantidad: ${cantidad} Precio: ${pocion.valor*cantidad}"
            }
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


