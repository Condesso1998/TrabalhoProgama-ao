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
    private fun insere(db: SQLiteDatabase, cliente: Cliente) {
        cliente.id = TabelaBDCliente(db).insert(cliente.toContentValues())
        assertNotEquals(-1, cliente.id)
    }


    @Before
    fun apagaBaseDados() {
        appContext().deleteDatabase(BDStandOpenHelper.NOME)
    }
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("pt.ipg.trabalhofinal", appContext.packageName)
    }
}