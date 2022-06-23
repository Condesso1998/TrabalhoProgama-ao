package pt.ipg.trabalhofinal

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import android.provider.BaseColumns

class ContentProviderTrabalhoFinal: ContentProvider() {
    var dbOpenHelper: BDStandOpenHelper? = null


    override fun onCreate(): Boolean {
        dbOpenHelper = BDStandOpenHelper(context)

        return true
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        TODO("Not yet implemented")
    }

    override fun getType(uri: Uri) {
        when (getUriMatcher().match(uri)) {
            URI_Carros -> "$MULTIPLOS_REGISTOS/${TabelaBDCarros.MATRICULA}"
            URI_Clientes -> "$MULTIPLOS_REGISTOS/${TabelaBDCliente.NOME}"
            URI_Carros_ESPECIFICO -> "$UNICO_REGISTO/${TabelaBDCarros.MATRICULA}"
            URI_Cliente_ESPECIFICO -> "$UNICO_REGISTO/${TabelaBDCliente.NOME}"
            else -> null
        }


    }
    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val db = dbOpenHelper!!.writableDatabase

        requireNotNull(values)

        val id = when (getUriMatcher().match(uri)) {
            URI_Carros -> TabelaBDCarros(db).insert(values)
            URI_CATEURI_ClientesGORIAS -> TabelaBDCliente(db).insert(values)
            else -> -1
        }

        db.close()

        if (id == -1L) return null

        return Uri.withAppendedPath(uri, "$id")
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        val db = dbOpenHelper!!.writableDatabase

        val id = uri.lastPathSegment

        val registosApagados = when (getUriMatcher().match(uri)) {
            URI_Carro_ESPECIFICO -> TabelaBDCarros(db).delete("${BaseColumns._ID}=?", arrayOf("${id}"))
            URI_Cliente_ESPECIFICO -> TabelaBDCliente(db).delete("${BaseColumns._ID}=?", arrayOf("${id}"))
            else -> 0
        }

        db.close()

        return registosApagados
    }







    }

