package com.example.ejercicio7

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper




class DbHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {


    companion object {
        private const val DATABASE_NAME = "personajes.db"
        private const val DATABASE_VERSION = 1
        //Tabla Personaje
        private const val TABLE_PERSONAJE = "personajes"
        private const val ID_PERSONAJE = "id_personaje"
        private const val NOMBRE = "nombre"
        private const val ESTADO_VITAL = "estadoVital"
        private const val RAZA = "raza"
        private const val CLASE = "clase"
        private const val FUERZA = "fuerza"
        private const val DESTREZA = "destreza"
        private const val DEFENSA = "defensa"
        private const val INTELIGENCIA = "inteligencia"
        private const val CONSTITUCION = "constitucion"
        private const val SABIDURIA = "sabiduria"
        private const val CARISMA = "carisma"
        private const val VIDA = "vida"
        private const val id_mochila = "id_mochila"
        private const val id_monedero = "id_monedero"


        //Tabla Mochila
        private const val TABLE_MOCHILA = "mochila"
        private const val mochila_id = "id_mochila"
        private const val objeto_id = "id_objeto"
        private const val PESO_MOCHILA = "peso_mochila"
        private const val PESO_MAXIMO = "peso_maximo"

        //Tabla Monedero
        private const val TABLE_MONEDERO = "monedero"
        private const val monedero_id = "id_monedero"
        private const val personaje_id = "personaje_id"
        private const val uno = "1"
        private const val diez = "10"
        private const val veinte = "20"
        private const val cincuenta = "50"
        private const val cien = "100"


        //Tabla de Objetos aleatorios
        private const val TABLE_OBJETOS_ALEATORIOS = "objetos_aleatorios"
        private const val id_objeto = "id_objeto"
        private const val NOMBRE_OBJETO = "nombre_objeto"
        private const val PESO = "peso"
        private const val VALOR = "valor"
        private const val VIDA_OBJETO = "vida_objeto"
        private const val DANIO = "danio"
        private const val RECUPERACION = "recuperacion"
        private const val DEFENSA_OBJETO = "defensa_objeto"
        private const val AUMNETO_HP = "aumento_hp"

    }


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PERSONAJE")
        onCreate(db)

    }
}