package com.example.ejercicio7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7.databinding.ActivityCiudadBinding
import com.google.gson.Gson

class Ciudad : AppCompatActivity() {
    private lateinit var binding: ActivityCiudadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCiudadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mPrefs = getPreferences(MODE_PRIVATE)
        val gson = Gson()
        val json = mPrefs.getString("Personaje", "")
        val p = gson.fromJson(json, Personaje::class.java)

        binding.ciudad.setImageResource(R.drawable.ciudad)

        val prefs = mPrefs.edit()
        val json2 = gson.toJson(p)
        prefs.putString("Personaje", json)
        prefs.apply()

        binding.Continuar.setOnClickListener{
            val intent = Intent(this@Ciudad, EntradaACiu::class.java)
            startActivity(intent)
        }

        binding.Volver.setOnClickListener{
            val intent = Intent(this@Ciudad, Ejercicio10::class.java)
            startActivity(intent)
        }
    }
}