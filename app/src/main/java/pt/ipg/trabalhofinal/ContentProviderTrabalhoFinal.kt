package pt.ipg.trabalhofinal

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import android.provider.BaseColumns

class ContentProviderTrabalhoFinal: ContentProvider() {
    var dbOpenHelper : BDStandOpenHelper? = null


    override fun onCreate(): Boolean {
        dbOpenHelper = BDStandOpenHelper(context)

        return true
    }

    override fun query(
        Uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        val db = dbOpenHelper!!.readableDatabase

        requireNotNull(projection)
        val colunas = projection as Array<String>

        val argsSeleccao = selectionArgs as Array<String>?


        val id = uri.lastPathSegment

        val cursor = when (getUriMatcher().match(uri)) {
            URI_Carros -> TabelaBDCarros(db).query(colunas, selection, argsSeleccao, null, null, sortOrder)
            URI_Clientes -> TabelaBDCliente(db).query(colunas, selection, argsSeleccao, null, null, sortOrder)
            URI_Carros_ESPECIFICO -> TabelaBDCarros(db).query(colunas, "${BaseColumns._ID}=?", arrayOf("${id}"), null, null, null)
            URI_Cliente_ESPECIFICO -> TabelaBDCliente(db).query(colunas, "${BaseColumns._ID}=?", arrayOf("${id}"), null, null, null)
            else -> null
        }

        db.close()

        return cursor
    }




}