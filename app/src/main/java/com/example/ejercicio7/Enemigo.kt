package com.example.ejercicio7

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityEnemigoBinding
import com.google.gson.Gson
import java.lang.Thread.sleep

class Enemigo : AppCompatActivity() {
    private lateinit var binding: ActivityEnemigoBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnemigoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val shared = getSharedPreferences("Personaje", Context.MODE_PRIVATE)
        val gson = Gson()
        var json = shared.getString("Personaje", "")
        val p = gson.fromJson(json, Personaje::class.java)
        val enemigo = Personaje()
        val tipo = intent.getStringExtra("tipo")
        binding.cantidadHP2.text = "200/${p.vida}"
        binding.turno.text = "Empieza el combate"
        enemigo.vida = 100
        enemigo.defensa = (1..5).random()


        if (tipo == "Normal") {
            binding.imageView2.setImageResource(R.drawable.enemigo1)
        } else if (tipo == "Boss") {
            binding.imageView2.setImageResource(R.drawable.enemigo)
            binding.HPEnemigo.text = "HP Boss"
            enemigo.vida = 200
            binding.CantidadHP.text = "200/${enemigo.vida}"
            enemigo.defensa = 5
        }



        binding.Atacar.setOnClickListener {
            atacarEnemigo(p, enemigo, tipo)
            if (enemigo.vida <= 0) {
                for (i in 1..3) {
                    p.mochila.add(Objetos("Pocion", 2, 50, 100))
                    p.pesoMochila -= 2
                }
                p.monedero["50"] = 100
                binding.turno.text = "Has ganado el combate, conseguiste 3 pociones y 100 monedas de 50"
                binding.Atacar.text = "Continuar"
                binding.Huir.isEnabled = false
                binding.Objetos.isEnabled = false
                binding.Atacar.setOnClickListener {
                    val editor = shared.edit()
                    editor.clear()
                    json = gson.toJson(p)
                    editor.putString("Personaje", json)
                    editor.apply()
                    val intent = Intent(this@Enemigo, Ejercicio10::class.java)
                    startActivity(intent)
                }
            } else if (p.vida <= 0) {
                val intent = Intent(this@Enemigo, Muerte::class.java)
                startActivity(intent)
            } else {

                if (tipo == "Normal") {
                    p.vida -= 20 / p.defensa
                    binding.cantidadHP2.text = "200/${p.vida}"
                } else if (tipo == "Boss") {
                    p.vida -= 30 / p.defensa
                    binding.cantidadHP2.text = "200/${p.vida}"
                }
            }
        }

        binding.Objetos.setOnClickListener {
            if (tipo != null) {
                objetos(p)
            }
            if (tipo == "Normal") {
                p.vida -= 20 / p.defensa
                binding.cantidadHP2.text = "200/${p.vida}"
            } else if (tipo == "Boss") {
                p.vida -= 30 / p.defensa
                binding.cantidadHP2.text = "200/${p.vida}"
            }

            if (p.vida <= 0) {
                val intent = Intent(this@Enemigo, Muerte::class.java)
                startActivity(intent)

            }

            binding.Huir.setOnClickListener {
                val editor = shared.edit()
                editor.clear()
                json = gson.toJson(p)
                editor.putString("Personaje", json)
                editor.apply()
                if (tipo != null) {
                    huir()
                }
                if (tipo == "Normal") {
                    p.vida -= 20 / p.defensa
                    binding.cantidadHP2.text = "200/${p.vida}"
                } else if (tipo == "Boss") {
                    p.vida -= 30 / p.defensa
                    binding.cantidadHP2.text = "200/${p.vida}"
                }

                if (p.vida <= 0) {
                    val intent = Intent(this@Enemigo, Muerte::class.java)
                    startActivity(intent)
                }

            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun atacarEnemigo(personaje: Personaje, enemigo: Personaje,tipo : String?){
        val aleatorio = (1..6).random()
        if(aleatorio in 4..6){
            enemigo.vida -= personaje.fuerza - enemigo.defensa
            binding.turno.text = "Has atacado al enemigo y le has quitado ${personaje.fuerza - enemigo.defensa} de vida,\n ahora es el turno del enemigo"
            if(tipo == "Normal"){
                binding.CantidadHP.text = "100/${enemigo.vida}"
            }else if(tipo == "Boss"){
                binding.CantidadHP.text = "200/${enemigo.vida}"
            }
        }else if(aleatorio in 1..3){
            //Ataque fallido del personaje
            binding.turno.text = "Has fallado el ataque,\n ahora es el turno del enemigo"

        }
    }

    @SuppressLint("SetTextI18n")
    fun huir(){
        val aleatorio = (1..6).random()
        val intent = Intent(this@Enemigo, Ejercicio10::class.java)
        if(aleatorio in 5..6){
            startActivity(intent)
        }else{
            binding.turno.text = "No has podido huir, turno del enemigo"
        }

    }

    @SuppressLint("SetTextI18n")
    fun objetos(personaje: Personaje){
        if(personaje.vida < 200 ){
            personaje.mochila.remove(Objetos("Pocion", 2, 50, 100))
            personaje.vida += 20
            binding.cantidadHP2.text = "200/${personaje.vida}"
        }else{
            binding.turno.text = "No tienes pociones o no puedes usarlas"
        }
    }

}