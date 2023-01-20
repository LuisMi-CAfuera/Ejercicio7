package com.example.ejercicio7

class Personaje{
    var nombre: String = ""
    var pesoMochila: Int = 0
    var estadoVital: String= ""
    var raza: String=""
    var clase: String=""
    var fuerza : Int=0
    var destreza : Int=0
    var inteligencia : Int=0
    var constitucion : Int=0
    var sabiduria : Int=0
    var carisma : Int=0
    var vida : Int=0
    var contvic : Int=0


    constructor()
    constructor(nombre: String, pesoMochila: Int, estadoVital: String, raza: String, clase: String, fuerza: Int, destreza: Int, inteligencia: Int, constitucion: Int, sabiduria: Int, carisma: Int, vida: Int, contvic: Int) {
        this.nombre = nombre
        this.pesoMochila = pesoMochila
        this.estadoVital = estadoVital
        this.raza = raza
        this.clase = clase
        this.fuerza = fuerza
        this.destreza = destreza
        this.inteligencia = inteligencia
        this.constitucion = constitucion
        this.sabiduria = sabiduria
        this.carisma = carisma
        this.vida = vida
        this.contvic = contvic
    }

    //Funcion que me diga que raza es aleatoriamente
    fun Raza():String{
        var raza : String = " "
        var razas = arrayOf("Elfo","Humano","Enano","Goblin")

        raza = razas.random()

        return raza
    }
    //Funcion que me diga si es adolescente,adulto o anciano aleatoriamente
    fun Edad():String{
        var edad : String = " "
        var edades = arrayOf("Adolescente","Adulto","Anciano")

        edad = edades.random()

        return edad
    }

    //Funcion que me de un nombre del EldenRing(Por que me apetece) aleatorio de un array de 7  nombres
    fun Nombre():String{
        var nombre : String = " "
        var nombres = arrayOf("Gwyn","Gwyndolin","Gwynevere","Malenia","Melina","Ranni","Radagon")

        nombre = nombres.random()

        return nombre
    }

    //Funcion que me diga el tipo de clase
    fun Clase():String{
        var clase : String = " "
        var clases = arrayOf("Guerrero","Mago","Ladron","Berserk")

        clase = clases.random()

        return clase
    }


    //Esta clase es solo para crear el personaje si no quieres que sea aleatorio
    fun crearPersonaje():Personaje{
        var personaje = Personaje()

        println("¿Que raza quieres que sea?(Elfo,Humano,Enano,Goblin o una que te inventes)")
        personaje.raza = readLine().toString()
        println("¿Que nombre quieres que tenga?(Si el personaje es un Elfo o un Goblin el nombre estara en elfico o goblin)")
        personaje.nombre = readLine().toString()
        println("¿Que edad quieres que tenga?(Adolescente,Adulto o Anciano)")
        personaje.estadoVital = readLine().toString()
        println("¿Que clase quieres ser?(Mago,Guerrero,Ladron o Berserk)")
        personaje.clase = readLine().toString()

        return personaje
    }

}