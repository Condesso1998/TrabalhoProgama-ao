package pt.ipg.trabalhofinal

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDVendas (val db: SQLiteDatabase){

    fun cria(){
        db.execSQL("CREATE TABLE $Nvenda(${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $DataVenda TEXT NOT NULL, $CAMPO_NOME TEXT NOT NULL)")

    }

    companion object {
        const val Nvenda=" numero da venda"
        const val DataVenda="data da venda"
        const val CAMPO_NOME ="nome"
    }
}