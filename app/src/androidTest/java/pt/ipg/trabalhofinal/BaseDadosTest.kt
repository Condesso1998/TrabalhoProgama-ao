package pt.ipg.trabalhofinal


import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import pt.ipg.livros.BDLivrosOpenHelper

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
        val openHelper = BDLivrosOpenHelper(appContext())
        return openHelper.writableDatabase
    }

    private fun insereCliente(db: SQLiteDatabase, cliente: Cliente) {
        Cliente.id = TabelaBDCliente(db).insert(Cliente.toContentValues())
        assertNotEquals(-1, Cliente.id)
    }

    private fun insereLivro(db: SQLiteDatabase, livro: Livro) {
        livro.id = TabelaBDLivros(db).insert(livro.toContentValues())
        assertNotEquals(-1, livro.id)
    }

    @Before
    fun apagaBaseDados() {
        appContext().deleteDatabase(BDLivrosOpenHelper.NOME)
    }
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("pt.ipg.trabalhofinal", appContext.packageName)
    }
}