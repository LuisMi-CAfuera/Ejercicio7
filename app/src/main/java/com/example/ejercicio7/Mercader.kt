package com.example.ejercicio7

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.ejercicio7.databinding.ActivityMercaderBinding
import com.google.gson.Gson

class Mercader : AppCompatActivity() {
    private lateinit var binding: ActivityMercaderBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMercaderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val shared = getSharedPreferences("Personaje", Context.MODE_PRIVATE)
        val gson = Gson()
        var json = shared.getString("Personaje", "")
        val p = gson.fromJson(json, Personaje::class.java)
        p.monedero.put("1",100)
        p.monedero.put("10",100)
        p.monedero.put("20",100)
        p.monedero.put("50",100)
        p.monedero.put("100",100)
        binding.Mercader.setImageResource(R.drawable.mercader)



        binding.Comerciar.setOnClickListener {
            binding.Comerciar.visibility = View.INVISIBLE
            binding.Comprar.visibility = View.VISIBLE
            binding.Vender.visibility = View.VISIBLE
            binding.Cancelar.visibility = View.VISIBLE
            binding.Volver.visibility = View.INVISIBLE
        }

        binding.Comprar.setOnClickListener {
            binding.spinner.visibility = View.VISIBLE
            binding.Comprar.visibility = View.INVISIBLE
            binding.Vender.visibility = View.INVISIBLE
            binding.Cancelar.visibility = View.INVISIBLE
            binding.mas.visibility = View.VISIBLE
            binding.menos.visibility = View.VISIBLE
            binding.CantidadYPrecio.visibility = View.VISIBLE
            binding.CantidadYPrecio.text = "Cantidad: 0 Precio: 0"
            binding.ComprarOVender.visibility = View.VISIBLE
            comprar(binding,p)
        }



        binding.Cancelar.setOnClickListener {
            binding.Comerciar.visibility = View.VISIBLE
            binding.Comprar.visibility = View.INVISIBLE
            binding.Vender.visibility = View.INVISIBLE
            binding.Cancelar.visibility = View.INVISIBLE
            binding.Volver.visibility = View.VISIBLE
        }








        binding.Volver.setOnClickListener {
            val intent = Intent(this@Mercader, Ejercicio10::class.java)
            val edit = shared.edit()
            edit.clear()
            json = gson.toJson(p)
            edit.putString("Personaje", json)
            edit.apply()
            startActivity(intent)
        }


    }
    fun comprar(binding: ActivityMercaderBinding,p : Personaje){
        val espada = Objetos("Espada", 14, 125, 200)
        val escudo = Objetos("Escudo", 10, 100, 250)
        val armadura = Objetos("Armadura", 20, 150, 300)
        val pocion = Objetos("Pocion", 2, 50, 100)
        var cantidad = 0
        var pago = 0
        var aux = 0
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @SuppressLint("SetTextI18n")
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (binding.spinner.selectedItem.toString()) {
                    " " -> {
                        cantidad = 0
                        binding.Mercader.setImageResource(R.drawable.mercader)
                        binding.CantidadYPrecio.text = "Cantidad: $cantidad Precio: 0"
                    }

                    "Espada" -> {
                        binding.Mercader.setImageResource(R.drawable.espada)
                        cantidad = 0
                        binding.mas.setOnClickListener {
                            cantidad++
                            binding.CantidadYPrecio.text =
                                "Cantidad: $cantidad Precio: ${cantidad * espada.valor}"
                        }
                        binding.menos.setOnClickListener {
                            if (cantidad > 0) {
                                cantidad--
                                binding.CantidadYPrecio.text =
                                    "Cantidad: $cantidad Precio: ${cantidad * espada.valor}"
                            }
                        }
                        pago = cantidad * espada.valor
                    }

                    "Escudo" -> {
                        binding.Mercader.setImageResource(R.drawable.escudo)
                        cantidad = 0
                        binding.mas.setOnClickListener {
                            cantidad++
                            binding.CantidadYPrecio.text =
                                "Cantidad: $cantidad Precio: ${cantidad * escudo.valor}"
                        }
                        binding.menos.setOnClickListener {
                            if (cantidad > 0) {
                                cantidad--
                                binding.CantidadYPrecio.text =
                                    "Cantidad: $cantidad Precio: ${cantidad * escudo.valor}"
                            }
                        }
                        pago = cantidad * escudo.valor
                    }

                    "Armadura" -> {
                        binding.Mercader.setImageResource(R.drawable.armadura)
                        cantidad = 0
                        binding.mas.setOnClickListener {
                            cantidad++
                            binding.CantidadYPrecio.text =
                                "Cantidad: $cantidad Precio: ${cantidad * armadura.valor}"
                        }
                        binding.menos.setOnClickListener {
                            if (cantidad > 0) {
                                cantidad--
                                binding.CantidadYPrecio.text =
                                    "Cantidad: $cantidad Precio: ${cantidad * armadura.valor}"
                            }
                        }
                        pago = cantidad * armadura.valor
                    }

                    "Pocion de HP" -> {
                        binding.Mercader.setImageResource(R.drawable.pocion)
                        cantidad = 0
                        binding.mas.setOnClickListener {
                            cantidad++
                            binding.CantidadYPrecio.text =
                                "Cantidad: $cantidad Precio: ${cantidad * pocion.valor}"
                        }
                        binding.menos.setOnClickListener {
                            if (cantidad > 0) {
                                cantidad--
                                binding.CantidadYPrecio.text =
                                    "Cantidad: $cantidad Precio: ${cantidad * pocion.valor}"
                            }
                        }
                        pago = cantidad * pocion.valor
                    }
                }

                binding.ComprarOVender.setOnClickListener{


                    if(pago % p.monedero.getValue("100") == 0 ){
                        
                    }
                }



            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


    }

    @SuppressLint("SetTextI18n")
    fun vender(binding: ActivityMercaderBinding, p:Personaje) {
        binding.Mercader.setImageResource(R.drawable.cars1)
        val lista = ArrayList<String>()
        //HAshMap para guardar el objeto y la cantidad
        val objetos = HashMap<String, Int>()
        for (i in p.mochila) {
            lista.add(i.nombre)
        }

        if (lista.isEmpty()) {
            binding.CantidadYPrecio.text = "No tienes objetos en tu mochila"
            binding.Comerciar.visibility = View.VISIBLE
            binding.Comprar.visibility = View.INVISIBLE
            binding.Vender.visibility = View.INVISIBLE
            binding.Cancelar.visibility = View.INVISIBLE
            binding.Volver.visibility = View.VISIBLE
            binding.spinner.visibility = View.INVISIBLE
            binding.mas.visibility = View.INVISIBLE
            binding.menos.visibility = View.INVISIBLE

        } else {
            for (i in lista) {
                if (objetos.containsKey(i)) {
                    objetos.put(i, objetos[i]!! + 1)
                } else {
                    objetos.put(i, 1)
                }
            }

            val adapter = ArrayAdapter(
                this@Mercader,
                android.R.layout.simple_spinner_item,
                objetos.keys.toList()
            )
            binding.spinner.adapter = adapter

            binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                @SuppressLint("SetTextI18n")
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    when (binding.spinner.selectedItem.toString()) {
                        "Objeto Random" -> {

                        }
                        "Espada" -> {

                        }
                        "Escudo" -> {

                        }
                        "Armadura" -> {

                        }
                        "Pocion de HP" -> {

                        }
                    }

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }


        }
    }

}



