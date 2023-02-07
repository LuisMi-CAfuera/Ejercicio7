package com.example.ejercicio7

import android.content.Context
import com.google.gson.Gson

class Personaje{
    var nombre: String = ""
    var pesoMochila: Int = 0
    var estadoVital: String= ""
    var raza: String=""
    var clase: String=""
    var fuerza : Int=0
    var destreza : Int=0
    var defensa : Int=0
    var inteligencia : Int=0
    var constitucion : Int=0
    var sabiduria : Int=0
    var carisma : Int=0
    var vida : Int=0
    var contvic : Int=0
    var mochila : ArrayList<Objetos> = ArrayList()



    constructor()
    constructor(nombre: String, pesoMochila: Int, estadoVital: String, raza: String, clase: String, fuerza: Int, destreza: Int,defensa : Int, inteligencia: Int, constitucion: Int, sabiduria: Int, carisma: Int, vida: Int, contvic: Int, mochila: ArrayList<Objetos>) {
        this.nombre = nombre
        this.pesoMochila = pesoMochila
        this.estadoVital = estadoVital
        this.raza = raza
        this.clase = clase
        this.fuerza = fuerza
        this.destreza = destreza
        this.defensa = defensa
        this.inteligencia = inteligencia
        this.constitucion = constitucion
        this.sabiduria = sabiduria
        this.carisma = carisma
        this.vida = vida
        this.contvic = contvic
        this.mochila = mochila
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

    fun inicializacion(p : Personaje): Personaje{

        when(p.raza){

            "Elfo" ->{
                p.sabiduria = 7
                p.destreza = 7
                p.inteligencia = 7
            }
            "Humano" ->{
                p.fuerza = 5
                p.destreza = 5
                p.constitucion = 5
                p.inteligencia = 5
            }
            "Enano" ->{
                p.fuerza = 10
                p.constitucion=10
                p.destreza=10
            }
            "Orco" ->{
                p.destreza = 8
                p.fuerza = 8
                p.carisma = 8
            }


        }


        //Inicializamos las habilidades de los personajes, ya que como solo hay seis pues hasta que se cumpla
        var cont = 0
        for (i in 1..6){

            val dados = arrayListOf<Int>()
            var i = 0
            while (i < 4) {
                dados.add((1..6).random())
                i++
            }
            dados.sortDescending()
            dados.removeAt(0)

            when(cont){
                1 -> p.fuerza += dados.sum()
                2 -> p.destreza += dados.sum()
                3 -> p.constitucion += dados.sum()
                4 -> p.inteligencia += dados.sum()
                5 -> p.sabiduria += dados.sum()
                6 -> p.carisma += dados.sum()
            }


        }

        p.vida= 10 +(p.constitucion-10)/2



        return p
    }



    override fun toString(): String {
        return "Personaje(nombre='$nombre', pesoMochila=$pesoMochila, " +
                "estadoVital='$estadoVital', raza='$raza', clase='$clase', " +
                "fuerza=$fuerza, destreza=$destreza, defensa=$defensa, " +
                "inteligencia=$inteligencia, constitucion=$constitucion, " +
                "sabiduria=$sabiduria, carisma=$carisma, vida=$vida, " +
                "contvic=$contvic, mochila=$mochila)"
    }


}