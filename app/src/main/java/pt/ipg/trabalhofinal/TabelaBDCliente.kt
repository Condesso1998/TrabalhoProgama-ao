package pt.ipg.trabalhofinal

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDCliente (val db: SQLiteDatabase) {
    fun cria(){
        db.execSQL("CREATE TABLE $NOME (${BaseColumns._ID} TEXT PRIMARY KEY AUTOINCREMENT, $CAMPO_NIF INTEGER NOT NULL $CAMPO_TELEFONE INTEGER NOT NULL ON DELETE RESTRICT) ")

    }





    companion object{
        const val NOME ="nome"
        const val CAMPO_NIF = "nif"
        const val CAMPO_TELEFONE = "telefone"

    }

}