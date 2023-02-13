package com.example.ejercicio7

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper




class DbHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {


    companion object {
        private const val DATABASE_NAME = "personajes.db"
        private const val TABLE_PERSONAJE = "personajes"
        private const val TABLE_MOCHILA = "mochila"
        private const val TABLE_OBJETOS = "objetos"
        private const val DATABASE_VERSION = 1
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
        private const val MONEDERO = "monedero"
        private const val createTable = "CREATE TABLE $TABLE_PERSONAJE (" +
                "$NOMBRE TEXT PRIMARY KEY," +
                "$ESTADO_VITAL TEXT," +
                "$RAZA TEXT," +
                "$CLASE TEXT," +
                "$FUERZA INTEGER," +
                "$DESTREZA INTEGER," +
                "$DEFENSA INTEGER," +
                "$INTELIGENCIA INTEGER," +
                "$CONSTITUCION INTEGER," +
                "$SABIDURIA INTEGER," +
                "$CARISMA INTEGER," +
                "$VIDA INTEGER," +
                "$id_mochila TEXT," +
                "$MONEDERO TEXT)"
    }


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PERSONAJE")
        onCreate(db)

    }
}