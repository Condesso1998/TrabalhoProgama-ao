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

    override fun getType(uri: Uri): String? {
        return when (getUriMatcher().match(uri)) {
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
            URI_Cliente_ESPECIFICO -> TabelaBDCliente(db).insert(values)
            else -> -1
        }

        db.close()

        if (id == -1L) return null

        return Uri.withAppendedPath(uri, "$id")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        val db = dbOpenHelper!!.writableDatabase


        val id = uri.lastPathSegment

        val registosApagados = when (getUriMatcher().match(uri)) {
            URI_Carros_ESPECIFICO -> TabelaBDCarros(db).delete("${BaseColumns._ID}=?", arrayOf("${id}"))
            URI_Cliente_ESPECIFICO -> TabelaBDCliente(db).delete("${BaseColumns._ID}=?", arrayOf("${id}"))
            else -> 0
        }

        db.close()

        return registosApagados
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {

            requireNotNull(values)

            val db = dbOpenHelper!!.writableDatabase

            val id = uri.lastPathSegment

            val registosAlterados = when (getUriMatcher().match(uri)) {
                URI_Carros_ESPECIFICO -> TabelaBDCarros(db).update(values, "${BaseColumns._ID}=?", arrayOf("${id}"))
                URI_Cliente_ESPECIFICO -> TabelaBDCliente(db).update(values,"${BaseColumns._ID}=?", arrayOf("${id}"))
                else -> 0
            }

            db.close()

            return registosAlterados
        }
    companion object {
        const val AUTHORITY = "pt.ipg.trabalhofinal"

        const val URI_Clientes  = 100
        const val URI_Cliente_ESPECIFICO = 101
        const val URI_Carros = 200
        const val URI_Carros_ESPECIFICO  = 201

        const val UNICO_REGISTO = "vnd.android.cursor.item"
        const val MULTIPLOS_REGISTOS = "vnd.android.cursor.dir"

        fun getUriMatcher() : UriMatcher {
            var uriMatcher = UriMatcher(UriMatcher.NO_MATCH)

            uriMatcher.addURI(AUTHORITY, TabelaBDCliente.NOME, URI_Clientes)
            uriMatcher.addURI(AUTHORITY, "${TabelaBDCliente.NOME}/#", URI_Cliente_ESPECIFICO)
            uriMatcher.addURI(AUTHORITY, TabelaBDCarros.MATRICULA, URI_Carros)
            uriMatcher.addURI(AUTHORITY, "${TabelaBDCarros.MATRICULA}/#", URI_Carros_ESPECIFICO)

            return uriMatcher
        }
    }
    }




