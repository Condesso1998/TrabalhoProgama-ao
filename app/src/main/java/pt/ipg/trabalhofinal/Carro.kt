package pt.ipg.trabalhofinal

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns

 data class Carro(

     var Matricula: String,
     var Marca: String,
     var Modelo: String,
     var Cor: String,
     var id: Cliente = -1

         ){


     fun toContentValues() : ContentValues {
         val valores = ContentValues()

         valores.put(TabelaBDCarros.MATRICULA, Matricula)
         valores.put(TabelaBDCarros.MARCA, Marca)
         valores.put(TabelaBDCarros.MODELO, Modelo)
         valores.put(TabelaBDCarros.COR, Cor)

         return valores
     }

     companion object {
         fun fromCursor(cursor: Cursor): Carro {
             val posId = cursor.getColumnIndex(BaseColumns._ID)
             val posMatricula = cursor.getColumnIndex(TabelaBDCarros.MATRICULA)
             val posMarca = cursor.getColumnIndex(TabelaBDCarros.MARCA)
             val posModelo= cursor.getColumnIndex(TabelaBDCarros.MODELO)
             val posCor = cursor.getColumnIndex(TabelaBDCarros.COR)


             val id = cursor.getLong(posId)
             val Matricula = cursor.getString(posMatricula)
             val Marca = cursor.getString(posMarca)
             val MODELO = cursor.getString(posModelo)
             val COR = cursor.getString(posCor)

             return Carro(Matricula, Marca, MODELO, COR)
         }
     }
 }
