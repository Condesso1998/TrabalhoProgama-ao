package pt.ipg.trabalhofinal

import android.database.sqlite.SQLiteDatabase

class BDStandOpenHelper {
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
    ) : SQLiteOpenHelper(context, name, factory, version) {
        override fun onCreate(db: SQLiteDatabase?) {
            requireNotNull(db)

            TabelaBDCarros(db).cria()
            TabelaBDCliente(db).cria()
            TabelaBDVendas(db).cria()


        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

        }
}