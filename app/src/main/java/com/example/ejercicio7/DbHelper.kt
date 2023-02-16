package com.example.ejercicio7

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper




class DbHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {


    companion object {
        private const val DATABASE_NAME = "personajes.db"
        private const val DATABASE_VERSION = 1


        //Tabla de Objetos aleatorios
        private const val TABLE_OBJETOS_ALEATORIOS = "objetos_aleatorios"
        private const val ID_OBJETO = "id_objeto"
        private const val NOMBRE_OBJETO = "nombre_objeto"
        private const val PESO = "peso"
        private const val VALOR = "valor"
        private const val VIDA_OBJETO = "vida_objeto"
        private const val DANIO = "danio"
        private const val RECUPERACION = "recuperacion"
        private const val DEFENSA_OBJETO = "defensa_objeto"
        private const val AUMNETO_HP = "aumento_hp"
        private const val CREATE_TABLE_OBJETOS_ALEATORIOS = ("CREATE TABLE " + TABLE_OBJETOS_ALEATORIOS + "("
                + ID_OBJETO + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NOMBRE_OBJETO + " TEXT,"
                + PESO + " INTEGER,"
                + VALOR + " INTEGER,"
                + VIDA_OBJETO + " INTEGER,"
                + DANIO + " INTEGER,"
                + RECUPERACION + " INTEGER,"
                + DEFENSA_OBJETO + " INTEGER,"
                + AUMNETO_HP + " INTEGER"
                + ")")

        //Tabla Mochila
        private const val TABLE_MOCHILA = "mochila"
        private const val MOCHILA_ID = "id_mochila"
        private const val PESO_MOCHILA = "peso_mochila"
        private const val PESO_MAXIMO = "peso_maximo"
        private const val CREATE_TABLE_MOCHILA = ("CREATE TABLE " + TABLE_MOCHILA + "("
                + MOCHILA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PESO_MOCHILA + " INTEGER,"
                + PESO_MAXIMO + " INTEGER"
                + ")")
        //Tabla de Objetos y mochila
        private const val TABLE_OBJETOS_Y_MOCHILA = "objetos_y_mochila"
        private const val ID_OBJETO_Y_MOCHILA_OBJETO = "id_objeto"
        private const val ID_OBJETO_Y_MOCHILA_MOCHILA = "id_mochila"
        private const val CREATE_TABLE_OBJETOS_Y_MOCHILA = ("CREATE TABLE " + TABLE_OBJETOS_Y_MOCHILA + "("
                + ID_OBJETO_Y_MOCHILA_OBJETO + " INTEGER,"
                + ID_OBJETO_Y_MOCHILA_MOCHILA + " INTEGER,"
                + "FOREIGN KEY (" + ID_OBJETO_Y_MOCHILA_OBJETO + ") REFERENCES " + TABLE_OBJETOS_ALEATORIOS + "(" + ID_OBJETO + "),"
                + "FOREIGN KEY (" + ID_OBJETO_Y_MOCHILA_MOCHILA + ") REFERENCES " + TABLE_MOCHILA + "(" + MOCHILA_ID + ")"
                + ")")
        //Tabla Monedero
        private const val TABLE_MONEDERO = "monedero"
        private const val monedero_id = "id_monedero"
        private const val UNO = "1"
        private const val DIEZ = "10"
        private const val VEINTE = "20"
        private const val CINCUENTA = "50"
        private const val CIEN = "100"
        private const val CREATE_TABLE_MONEDERO = ("CREATE TABLE " + TABLE_MONEDERO + "("
                + monedero_id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + UNO + " INTEGER,"
                + DIEZ + " INTEGER,"
                + VEINTE + " INTEGER,"
                + CINCUENTA + " INTEGER,"
                + CIEN + " INTEGER"
                + ")")
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
        private const val ID_MOCHILA = "id_mochila"
        private const val ID_MONEDERO = "id_monedero"
        private const val CREATE_TABLE_PERSONAJE = ("CREATE TABLE " + TABLE_PERSONAJE + "("
                + ID_PERSONAJE + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NOMBRE + " TEXT,"
                + ESTADO_VITAL + " TEXT,"
                + RAZA + " TEXT,"
                + CLASE + " TEXT,"
                + FUERZA + " INTEGER,"
                + DESTREZA + " INTEGER,"
                + DEFENSA + " INTEGER,"
                + INTELIGENCIA + " INTEGER,"
                + CONSTITUCION + " INTEGER,"
                + SABIDURIA + " INTEGER,"
                + CARISMA + " INTEGER,"
                + VIDA + " INTEGER,"
                + ID_MOCHILA + " INTEGER,"
                + ID_MONEDERO + " INTEGER,"
                + "FOREIGN KEY (" + ID_MOCHILA + ") REFERENCES " + TABLE_MOCHILA + "(" + MOCHILA_ID + "),"
                + "FOREIGN KEY (" + ID_MONEDERO + ") REFERENCES " + TABLE_MONEDERO + "(" + monedero_id + ")"
                + ")")
    }


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_OBJETOS_ALEATORIOS)
        db.execSQL(CREATE_TABLE_MOCHILA)
        db.execSQL(CREATE_TABLE_MONEDERO)
        db.execSQL(CREATE_TABLE_PERSONAJE)
        db.execSQL(CREATE_TABLE_OBJETOS_Y_MOCHILA)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_OBJETOS_ALEATORIOS")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_MOCHILA")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_MONEDERO")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PERSONAJE")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_OBJETOS_Y_MOCHILA")
        onCreate(db)

    }
}