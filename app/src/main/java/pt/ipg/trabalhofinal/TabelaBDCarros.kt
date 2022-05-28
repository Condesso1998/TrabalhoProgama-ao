package pt.ipg.trabalhofinal

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDCarros (val db: SQLiteDatabase) {
    fun cria(){
        db.execSQL("CREATE TABLE $IDCARRO (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $MATRICULA TEXT NOT NULL, $MARCA TEXT NOT NULL, $MODELO TEXT NOT NULL, $COR TEXT NOT NULL)  ")

    }





    companion object{
        const val IDCARRO ="nome"
        const val MATRICULA = "nif"
        const val MARCA = "marca"
        const val MODELO = "modelo"
        const val COR = "cor"

    }



}

