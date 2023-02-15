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

class MercaderCiudad : AppCompatActivity() {
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
        binding.Mercader.setImageResource(R.drawable.mercader1)



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
            val intent = Intent(this@MercaderCiudad, Ciudad::class.java)
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
                        binding.CantidadYPrecio.text = "Cantidad: $cantidad Precio: 0  Peso: 0"
                    }

                    "Espada" -> {
                        binding.Mercader.setImageResource(R.drawable.espada)
                        cantidad = 0
                        ido = "Espada"
                        binding.mas.setOnClickListener {
                            cantidad++
                            pago = cantidad * espada.valor
                            if(p.pesoMochila - (espada.peso * cantidad) <= 0){
                                binding.CantidadYPrecio.text = "No puedes comprar tanto"
                                binding.ComprarOVender.isEnabled = false
                            }
                            binding.CantidadYPrecio.text =
                                "Cantidad: $cantidad Precio: ${cantidad * espada.valor} Peso: ${cantidad * espada.peso}"
                        }
                        binding.menos.setOnClickListener {
                            if (cantidad > 0) {
                                cantidad--
                                pago = cantidad * espada.valor
                                binding.CantidadYPrecio.text =
                                    "Cantidad: $cantidad Precio: ${cantidad * espada.valor} Peso: ${cantidad * espada.peso}"
                            }
                            binding.ComprarOVender.isEnabled = true
                        }

                    }

                    "Escudo" -> {
                        binding.Mercader.setImageResource(R.drawable.escudo)
                        cantidad = 0
                        ido = "Escudo"
                        binding.mas.setOnClickListener {
                            cantidad++
                            pago = cantidad * escudo.valor
                            if(p.pesoMochila - (escudo.peso * cantidad) <= 0){
                                binding.CantidadYPrecio.text = "No puedes comprar tanto"
                                binding.ComprarOVender.isEnabled = false
                            }
                            binding.CantidadYPrecio.text =
                                "Cantidad: $cantidad Precio: ${cantidad * escudo.valor} Peso: ${cantidad * escudo.peso}"
                        }
                        binding.menos.setOnClickListener {
                            if (cantidad > 0) {
                                cantidad--
                                pago = cantidad * escudo.valor
                                binding.CantidadYPrecio.text =
                                    "Cantidad: $cantidad Precio: ${cantidad * escudo.valor} Peso : ${cantidad * escudo.peso}"
                            }
                            binding.ComprarOVender.isEnabled = true
                        }


                    }

                    "Armadura" -> {
                        binding.Mercader.setImageResource(R.drawable.armadura)
                        cantidad = 0
                        ido = "Armadura"
                        binding.mas.setOnClickListener {
                            cantidad++
                            pago = cantidad * armadura.valor
                            if(p.pesoMochila - (armadura.peso * cantidad) <= 0){
                                binding.CantidadYPrecio.text = "No puedes comprar tanto"
                                binding.ComprarOVender.isEnabled = false
                            }
                            binding.CantidadYPrecio.text =
                                "Cantidad: $cantidad Precio: ${cantidad * armadura.valor} Peso: ${cantidad * armadura.peso}"
                        }
                        binding.menos.setOnClickListener {
                            if (cantidad > 0) {
                                cantidad--
                                pago = cantidad * armadura.valor
                                binding.CantidadYPrecio.text =
                                    "Cantidad: $cantidad Precio: ${cantidad * armadura.valor} Peso: ${cantidad * armadura.peso}"
                            }
                            binding.ComprarOVender.isEnabled = true
                        }

                    }

                    "Pocion de HP" -> {
                        binding.Mercader.setImageResource(R.drawable.pocion)
                        cantidad = 0
                        ido = "Pocion de HP"
                        binding.mas.setOnClickListener {
                            cantidad++
                            pago = cantidad * pocion.valor
                            if(p.pesoMochila - (pocion.peso * cantidad) <= 0){
                                binding.CantidadYPrecio.text = "No puedes comprar tanto"
                                binding.ComprarOVender.isEnabled = false
                            }
                            binding.CantidadYPrecio.text =
                                "Cantidad: $cantidad Precio: ${cantidad * pocion.valor} Peso: ${cantidad * pocion.peso}"
                        }
                        binding.menos.setOnClickListener {
                            if (cantidad > 0) {
                                cantidad--
                                pago = cantidad * pocion.valor
                                binding.CantidadYPrecio.text =
                                    "Cantidad: $cantidad Precio: ${cantidad * pocion.valor} Peso: ${cantidad * pocion.peso}"
                            }
                            binding.ComprarOVender.isEnabled = true
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

                    when(ido){
                        "Espada" -> {
                            //Bucle para añadir la cantidad de espadas que se quiera
                            for(i in 0 until cantidad){
                                p.mochila.add(espada)
                            }
                            p.pesoMochila -= espada.peso * cantidad
                        }
                        "Escudo" -> {
                            //Bucle para añadir la cantidad de escudos que se quiera
                            for(i in 0 until cantidad){
                                p.mochila.add(escudo)
                            }
                            p.pesoMochila -= escudo.peso * cantidad
                        }
                        "Armadura" -> {
                            //Bucle para añadir la cantidad de armaduras que se quiera
                            for(i in 0 until cantidad){
                                p.mochila.add(armadura)
                            }
                            p.pesoMochila -= armadura.peso * cantidad
                        }
                        "Pocion de HP" -> {
                            //Bucle para añadir la cantidad de pociones que se quiera
                            for(i in 0 until cantidad){
                                p.mochila.add(pocion)
                            }
                            p.pesoMochila -= pocion.peso * cantidad
                        }
                    }
                    binding.CantidadYPrecio.text = "Gastaste $pago2 \n" +
                            "Te quedan ${p.monedero["100"]} billetes de 100,\n" +
                            "${p.monedero["50"]} billetes de 50,\n " +
                            "${p.monedero["20"]} billetes de 20,\n " +
                            "${p.monedero["10"]} billetes de 10 y\n " +
                            "${p.monedero["1"]} monedas de 1\n" +
                            "Peso de la mochila: ${p.pesoMochila}"
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


    }

    @SuppressLint("SetTextI18n")
    fun vender(binding: ActivityMercaderBinding, p:Personaje) {

        val espada = Objetos("Espada", 14, 125, 200)
        val escudo = Objetos("Escudo", 10, 100, 250)
        val armadura = Objetos("Armadura", 20, 150, 300)
        val pocion = Objetos("Pocion", 2, 50, 100)

        var cantidad = 0
        var pago = 0
        var aux = 0
        var ido = ""

        val lista = ArrayList<String>()
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
            binding.Mercader.setImageResource(R.drawable.cars1)
            binding.ComprarOVender.visibility = View.VISIBLE
            binding.ComprarOVender.text = "Vender"
            for (i in lista) {
                if (objetos.containsKey(i)) {
                    objetos.put(i, objetos[i]!! + 1)
                } else {
                    objetos.put(i, 1)
                }
            }

            val adapter = ArrayAdapter(
                this@MercaderCiudad,
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
                    when(binding.spinner.selectedItem.toString()){
                        "Objeto Random"->{
                            Toast.makeText(this@MercaderCiudad, "No puedes vender este objeto", Toast.LENGTH_SHORT).show()
                        }
                        "Espada"->{
                            cantidad = 0
                            ido = "Espada"
                            binding.mas.setOnClickListener {
                                if(cantidad < objetos["Espada"]!!){
                                    cantidad++
                                    pago = cantidad * espada.valor
                                    binding.CantidadYPrecio.text =
                                        "Cantidad: $cantidad Precio: ${cantidad * espada.valor} Peso: ${cantidad * espada.peso}"
                                }
                            }
                            binding.menos.setOnClickListener {
                                if (cantidad > 0) {
                                    cantidad--
                                    pago = cantidad * espada.valor
                                    binding.CantidadYPrecio.text =
                                        "Cantidad: $cantidad Precio: ${cantidad * espada.valor} Peso: ${cantidad * espada.peso}"
                                }
                            }
                        }
                        "Escudo"->{
                            binding.mas.setOnClickListener {
                                if(cantidad < objetos["Escudo"]!!){
                                    cantidad++
                                    pago = cantidad * escudo.valor
                                    binding.CantidadYPrecio.text =
                                        "Cantidad: $cantidad Precio: ${cantidad * escudo.valor} Peso: ${cantidad * escudo.peso}"
                                }
                            }
                            binding.menos.setOnClickListener {
                                if (cantidad > 0) {
                                    cantidad--
                                    pago = cantidad * escudo.valor
                                    binding.CantidadYPrecio.text =
                                        "Cantidad: $cantidad Precio: ${cantidad * escudo.valor} Peso: ${cantidad * escudo.peso}"
                                }
                            }
                        }
                        "Armadura"->{
                            binding.mas.setOnClickListener {
                                if(cantidad < objetos["Armadura"]!!){
                                    cantidad++
                                    pago = cantidad * armadura.valor
                                    binding.CantidadYPrecio.text =
                                        "Cantidad: $cantidad Precio: ${cantidad * armadura.valor} Peso: ${cantidad * armadura.peso}"
                                }
                            }
                            binding.menos.setOnClickListener {
                                if (cantidad > 0) {
                                    cantidad--
                                    pago = cantidad * armadura.valor
                                    binding.CantidadYPrecio.text =
                                        "Cantidad: $cantidad Precio: ${cantidad * armadura.valor} Peso: ${cantidad * armadura.peso}"
                                }
                            }
                        }
                        "Pocion"->{

                            binding.mas.setOnClickListener {
                                if(cantidad < objetos["Pocion"]!!){
                                    cantidad++
                                    pago = cantidad * pocion.valor
                                    binding.CantidadYPrecio.text =
                                        "Cantidad: $cantidad Precio: ${cantidad * pocion.valor} Peso: ${cantidad * pocion.peso}"
                                }
                            }
                            binding.menos.setOnClickListener {
                                if (cantidad > 0) {
                                    cantidad--
                                    pago = cantidad * pocion.valor
                                    binding.CantidadYPrecio.text =
                                        "Cantidad: $cantidad Precio: ${cantidad * pocion.valor} Peso: ${cantidad * pocion.peso}"
                                }
                            }
                        }
                    }

                    binding.ComprarOVender.setOnClickListener{
                        val pago2 = pago
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
                        binding.Mercader.setImageResource(R.drawable.mercader)
                        binding.spinner.visibility = View.INVISIBLE
                        binding.ComprarOVender.visibility = View.INVISIBLE
                        binding.mas.visibility = View.INVISIBLE
                        binding.menos.visibility = View.INVISIBLE
                        binding.Comerciar.visibility = View.VISIBLE
                        binding.Volver.visibility = View.VISIBLE

                        when(ido){
                            "Espada"->{
                                for(i in 0 until cantidad){
                                    p.mochila.remove(espada)
                                    objetos["Espada"] = objetos["Espada"]!! - 1
                                    p.pesoMochila -= espada.peso
                                }
                            }
                            "Escudo"->{
                                for(i in 0 until cantidad){
                                    p.mochila.remove(escudo)
                                    objetos["Escudo"] = objetos["Escudo"]!! - 1
                                    p.pesoMochila -= escudo.peso
                                }
                            }
                            "Armadura"->{
                                for(i in 0 until cantidad){
                                    p.mochila.remove(armadura)
                                    objetos["Armadura"] = objetos["Armadura"]!! - 1
                                    p.pesoMochila -= armadura.peso
                                }
                            }
                            "Pocion"->{
                                for(i in 0 until cantidad){
                                    p.mochila.remove(pocion)
                                    objetos["Pocion"] = objetos["Pocion"]!! - 1
                                    p.pesoMochila -= pocion.peso
                                }
                            }
                        }
                        binding.CantidadYPrecio.text = "Ganaste $pago2 \n" +
                                "Ahora tienes ${p.monedero["100"]} billetes de 100,\n" +
                                "${p.monedero["50"]} billetes de 50,\n " +
                                "${p.monedero["20"]} billetes de 20,\n " +
                                "${p.monedero["10"]} billetes de 10 y\n " +
                                "${p.monedero["1"]} monedas de 1\n" +
                                "Peso de la mochila: ${p.pesoMochila}"
                    }

                }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

        }
    }

}




