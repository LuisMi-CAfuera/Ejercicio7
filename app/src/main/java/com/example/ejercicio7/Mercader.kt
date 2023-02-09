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
        p.monedero["1"] = 100
        p.monedero["10"] = 100
        p.monedero["20"] = 100
        p.monedero["50"] = 100
        p.monedero["100"] = 100
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

        binding.Vender.setOnClickListener {
            binding.spinner.visibility = View.VISIBLE
            binding.Comprar.visibility = View.INVISIBLE
            binding.Vender.visibility = View.INVISIBLE
            binding.Cancelar.visibility = View.INVISIBLE
            binding.mas.visibility = View.VISIBLE
            binding.menos.visibility = View.VISIBLE
            binding.CantidadYPrecio.visibility = View.VISIBLE
            binding.CantidadYPrecio.text = "Cantidad: 0 Precio: 0"
            binding.ComprarOVender.visibility = View.VISIBLE
            vender(binding,p)
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
        var pago2 = 0
        var aux = 0
        var ido = ""
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
                        ido = "Espada"
                        binding.mas.setOnClickListener {
                            cantidad++
                            pago = cantidad * espada.valor
                            binding.CantidadYPrecio.text =
                                "Cantidad: $cantidad Precio: ${cantidad * espada.valor}"
                        }
                        binding.menos.setOnClickListener {
                            if (cantidad > 0) {
                                cantidad--
                                pago = cantidad * espada.valor
                                binding.CantidadYPrecio.text =
                                    "Cantidad: $cantidad Precio: ${cantidad * espada.valor}"
                            }
                        }
                        if(p.pesoMochila + espada.peso * cantidad > p.pesoMochila){
                            binding.CantidadYPrecio.text = "No puedes comprar tanto"
                            binding.ComprarOVender.isEnabled = false
                        }
                    }

                    "Escudo" -> {
                        binding.Mercader.setImageResource(R.drawable.escudo)
                        cantidad = 0
                        ido = "Escudo"
                        binding.mas.setOnClickListener {
                            cantidad++
                            pago = cantidad * escudo.valor
                            binding.CantidadYPrecio.text =
                                "Cantidad: $cantidad Precio: ${cantidad * escudo.valor}"
                        }
                        binding.menos.setOnClickListener {
                            if (cantidad > 0) {
                                cantidad--
                                pago = cantidad * escudo.valor
                                binding.CantidadYPrecio.text =
                                    "Cantidad: $cantidad Precio: ${cantidad * escudo.valor}"
                            }
                        }
                        if(p.pesoMochila + escudo.peso * cantidad > p.pesoMochila){
                            binding.CantidadYPrecio.text = "No puedes comprar tanto"
                            binding.ComprarOVender.isEnabled = false
                        }

                    }

                    "Armadura" -> {
                        binding.Mercader.setImageResource(R.drawable.armadura)
                        cantidad = 0
                        ido = "Armadura"
                        binding.mas.setOnClickListener {
                            cantidad++
                            pago = cantidad * armadura.valor
                            binding.CantidadYPrecio.text =
                                "Cantidad: $cantidad Precio: ${cantidad * armadura.valor}"
                        }
                        binding.menos.setOnClickListener {
                            if (cantidad > 0) {
                                cantidad--
                                pago = cantidad * armadura.valor
                                binding.CantidadYPrecio.text =
                                    "Cantidad: $cantidad Precio: ${cantidad * armadura.valor}"
                            }
                        }
                        if(p.pesoMochila + armadura.peso * cantidad > p.pesoMochila){
                            binding.CantidadYPrecio.text = "No puedes comprar tanto"
                            binding.ComprarOVender.isEnabled = false
                        }
                    }

                    "Pocion de HP" -> {
                        binding.Mercader.setImageResource(R.drawable.pocion)
                        cantidad = 0
                        ido = "Pocion de HP"
                        binding.mas.setOnClickListener {
                            cantidad++
                            pago = cantidad * pocion.valor
                            binding.CantidadYPrecio.text =
                                "Cantidad: $cantidad Precio: ${cantidad * pocion.valor}"
                        }
                        binding.menos.setOnClickListener {
                            if (cantidad > 0) {
                                cantidad--
                                pago = cantidad * pocion.valor
                                binding.CantidadYPrecio.text =
                                    "Cantidad: $cantidad Precio: ${cantidad * pocion.valor}"
                            }
                        }
                        if(p.pesoMochila + pocion.peso * cantidad > p.pesoMochila){
                            binding.CantidadYPrecio.text = "No puedes comprar tanto"
                            binding.ComprarOVender.isEnabled = false
                        }
                    }
                }

                binding.ComprarOVender.setOnClickListener{
                    pago2 = pago
                    aux = pago / 100
                    if(aux > 0){
                        pago -= 100 * aux
                        p.monedero["100"] = p.monedero["100"]!! - aux
                    }
                    aux = pago / 50
                    if(aux > 0){
                        pago -= 50 * aux
                        p.monedero["50"] = p.monedero["50"]!! - aux
                    }
                    aux = pago / 20
                    if(aux > 0){
                        pago -= 20 * aux
                        p.monedero["20"] = p.monedero["20"]!! - aux
                    }
                    aux = pago / 10
                    if(aux > 0){
                        pago -= 10 * aux
                        p.monedero["10"] = p.monedero["10"]!! - aux
                    }
                    aux = pago / 1
                    if(aux > 0){
                        pago -= 1 * aux
                        p.monedero["1"] = p.monedero["1"]!! - aux
                    }



                    binding.Mercader.setImageResource(R.drawable.mercader)
                    binding.spinner.visibility = View.INVISIBLE
                    binding.ComprarOVender.visibility = View.INVISIBLE
                    binding.mas.visibility = View.INVISIBLE
                    binding.menos.visibility = View.INVISIBLE
                    binding.Comerciar.visibility = View.VISIBLE
                    binding.Volver.visibility = View.VISIBLE
                    binding.CantidadYPrecio.text = "Gastaste $pago2 \n" +
                            "Te quedan ${p.monedero["100"]} billetes de 100,\n" +
                            "${p.monedero["50"]} billetes de 50,\n " +
                            "${p.monedero["20"]} billetes de 20,\n " +
                            "${p.monedero["10"]} billetes de 10 y\n " +
                            "${p.monedero["1"]} monedas de 1"

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
        var cantidad = 0
        var pago = 0
        var aux = 0
        val lista = ArrayList<String>()
        val objetos = HashMap<String, Int>()
        val objyprecios = HashMap<String, Int>()
        for (i in p.mochila) {
            lista.add(i.nombre)
        }
        for (i in p.mochila){
            objyprecios.put(i.nombre, i.valor)
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
                            cantidad = 0
                            binding.mas.setOnClickListener {
                                if (cantidad < objetos["Objeto Random"]!!) {
                                    cantidad++
                                    binding.CantidadYPrecio.text =
                                        "Cantidad: $cantidad Precio: ${cantidad * objyprecios["Objeto Random"]!!}"
                                }
                            }
                            binding.menos.setOnClickListener {
                                if (cantidad > 0) {
                                    cantidad--
                                }
                            }
                            pago = cantidad * objyprecios["Objeto Random"]!!
                        }
                        "Espada" -> {
                            cantidad = 0
                            binding.mas.setOnClickListener {
                                if (cantidad < objetos["Espada"]!!) {
                                    cantidad++
                                    binding.CantidadYPrecio.text =
                                        "Cantidad: $cantidad Precio: ${cantidad * objyprecios["Espada"]!!}"
                                }
                            }
                            binding.menos.setOnClickListener {
                                if (cantidad > 0) {
                                    cantidad--
                                }
                            }
                            pago = cantidad * objyprecios["Espada"]!!
                        }
                        "Escudo" -> {
                            cantidad = 0
                            binding.mas.setOnClickListener {
                                if (cantidad < objetos["Escudo"]!!) {
                                    cantidad++
                                    binding.CantidadYPrecio.text =
                                        "Cantidad: $cantidad Precio: ${cantidad * objyprecios["Escudo"]!!}"
                                }
                            }
                            binding.menos.setOnClickListener {
                                if (cantidad > 0) {
                                    cantidad--
                                }
                            }
                            pago = cantidad * objyprecios["Escudo"]!!
                        }
                        "Armadura" -> {
                            cantidad = 0
                            binding.mas.setOnClickListener {
                                if (cantidad < objetos["Armadura"]!!) {
                                    cantidad++
                                    binding.CantidadYPrecio.text =
                                        "Cantidad: $cantidad Precio: ${cantidad * objyprecios["Armadura"]!!}"
                                }
                            }
                            binding.menos.setOnClickListener {
                                if (cantidad > 0) {
                                    cantidad--
                                }
                            }
                            pago = cantidad * objyprecios["Armadura"]!!
                        }
                        "Pocion" -> {
                            cantidad = 0
                            binding.mas.setOnClickListener {
                                if (cantidad < objetos["Pocion"]!!) {
                                    cantidad++
                                    binding.CantidadYPrecio.text =
                                        "Cantidad: $cantidad Precio: ${cantidad * objyprecios["Pocion"]!!}"
                                }
                            }
                            binding.menos.setOnClickListener {
                                if (cantidad > 0) {
                                    cantidad--
                                }
                            }
                            pago = cantidad * objyprecios["Pocion"]!!
                        }
                    }

                    binding.ComprarOVender.text = "Vender"
                    binding.ComprarOVender.setOnClickListener{
                        aux = pago / 100
                        if(aux > 0){
                            pago -= 100 * aux
                            p.monedero["100"] = p.monedero["100"]!! + aux
                        }
                        aux = pago / 50
                        if(aux > 0){
                            pago -= 50 * aux
                            p.monedero["50"] = p.monedero["50"]!! + aux
                        }
                        aux = pago / 20
                        if(aux > 0){
                            pago -= 20 * aux
                            p.monedero["20"] = p.monedero["20"]!! + aux
                        }
                        aux = pago / 10
                        if(aux > 0){
                            pago -= 10 * aux
                            p.monedero["10"] = p.monedero["10"]!! + aux
                        }
                        aux = pago / 1
                        if(aux > 0){
                            pago -= 1 * aux
                            p.monedero["1"] = p.monedero["1"]!! + aux
                        }
                    }
                    binding.Mercader.setImageResource(R.drawable.mercader)
                    binding.spinner.visibility = View.INVISIBLE
                    binding.ComprarOVender.visibility = View.INVISIBLE
                    binding.mas.visibility = View.INVISIBLE
                    binding.menos.visibility = View.INVISIBLE
                    binding.Comerciar.visibility = View.VISIBLE
                    binding.Volver.visibility = View.VISIBLE
                    binding.CantidadYPrecio.text = "Conseguiste $pago"+
                            "Te quedan ${p.monedero["100"]} billetes de 100,\n" +
                            "${p.monedero["50"]} billetes de 50,\n " +
                            "${p.monedero["20"]} billetes de 20,\n " +
                            "${p.monedero["10"]} billetes de 10 y\n " +
                            "${p.monedero["1"]} monedas de 1"
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

        }
    }

}




