package com.example.ejercicio7

class PersonajeDB {
    var nombre: String = ""
    var pesoMochila: Int = 0
    var estadoVital: String = ""
    var raza: String = ""
    var clase: String = ""
    var fuerza: Int = 0
    var destreza: Int = 0
    var defensa: Int = 0
    var inteligencia: Int = 0
    var constitucion: Int = 0
    var sabiduria: Int = 0
    var carisma: Int = 0
    var vida: Int = 0
    var mochila: ArrayList<Objetos> = ArrayList()

    //Monedero que sea un diccionario con el nombre del objeto y el valor
    var monedero: MutableMap<String, Int> = mutableMapOf(
        "1" to 0,
        "10" to 0,
        "20" to 0,
        "50" to 0,
        "100" to 0
    )



}