package pt.ipg.trabalhofinal

import android.content.ContentValues

import android.database.Cursor
import android.provider.BaseColumns

class Cliente (var nome: String, var id: Long = -1) {

    fun toContentValues() : ContentValues {
        val valores = ContentValues()
        valores.put(TabelaBDCliente.NOME, nome)

        return valores
    }

    companion object {


        fun fromCursor (cursor: Cursor):  Any?{
            val posId = cursor.getColumnIndex(BaseColumns._ID)
            val posNome = cursor.getColumnIndex(TabelaBDCliente.NOME)
            val posNif = cursor.getColumnIndex(TabelaBDCliente.CAMPO_NIF)

            val id = cursor.getLong(posId)
            val nome = cursor.getString(posNome)
            val nif = cursor.getString(posNif)

            return Cliente(nome, id)
        }
    }
}



