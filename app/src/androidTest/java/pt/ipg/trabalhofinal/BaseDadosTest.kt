package pt.ipg.trabalhofinal


import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class BaseDadosTest {


    private fun appContext() =
        InstrumentationRegistry.getInstrumentation().targetContext

    private fun getWritableDatabase(): SQLiteDatabase {
        val openHelper = BDStandOpenHelper(appContext())
        return openHelper.writableDatabase
    }

    private fun insereCliente(db: SQLiteDatabase, cliente: Cliente) {
        cliente.id = TabelaBDCliente(db).insert(cliente.toContentValues())
        assertNotEquals(-1, cliente.id)
    }

    private fun insereCarro(db: SQLiteDatabase, Carro: Carro) {
        Carro.id = TabelaBDCarros(db).insert(Carro.toContentValues())
        assertNotEquals(-1, Carro.id)
    }

    @Before
    fun apagaBaseDados() {
        appContext().deleteDatabase(BDStandOpenHelper.NOME)
    }

    @Test
    fun consegueAbrirBaseDados() {
        val openHelper = BDStandOpenHelper(appContext())
        val db = openHelper.readableDatabase

        assertTrue(db.isOpen)

        db.close()
    }

    @Test
    fun consegueInserirCliente() {
        val db = getWritableDatabase()

        insereCliente(db, Cliente("Rui Condesso "))

        db.close()
    }


    fun consegueInserirLivro() {
        val db = getWritableDatabase()

        val categoria = Cliente("Rui Condesso")
        insereCliente(db, categoria)

        val Carro = Carro("AF-15-OU", "Mercedes", "A 45","Cinza")
        insereCarro(db, Carro);

        db.close()
    }
}