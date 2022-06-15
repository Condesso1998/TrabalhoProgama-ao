package pt.ipg.trabalhofinal

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import pt.ipg.livros.TabelaBD

class TabelaBDCarros (db: SQLiteDatabase) : TabelaBD(db, NOME) {
    override fun cria(){
        db.execSQL("CREATE TABLE $NOME (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $MATRICULA TEXT NOT NULL, $MARCA TEXT NOT NULL, $MODELO TEXT NOT NULL, $COR TEXT NOT NULL)  ")

    }





    companion object{
        const val NOME ="IDdoCarros"
        const val MATRICULA = "matricula"
        const val MARCA = "marca"
        const val MODELO = "modelo"
        const val COR = "cor"

    }



}

