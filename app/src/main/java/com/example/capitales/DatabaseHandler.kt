package com.example.capitales

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "World"
        private const val TABLE_NAME = "Capital"
        private const val KEY_ID = "_id"
        private const val KEY_DATA1 = "ciudad"
        private const val KEY_DATA2 = "pais"
        private const val KEY_DATA3 = "poblacion"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_NAME ($KEY_ID INTEGER PRIMARY KEY, $KEY_DATA1 TEXT, $KEY_DATA2 TEXT, $KEY_DATA3 INTEGER)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addData(country: String, city: String, population: Int ): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_DATA1, country)
        values.put(KEY_DATA2, city)
        values.put(KEY_DATA3, population)
        val result = db.insert(TABLE_NAME, null, values)
        return result != (-1).toLong()
    }

    fun getAllData(): ArrayList<String> {
        val dataList = ArrayList<String>()
        val db = this.readableDatabase
        val selectAllQuery = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(selectAllQuery, null)
        if (cursor.moveToFirst()) {
            do {
                if (cursor.getColumnIndex(KEY_DATA1) >= 0 )
                {
                    val data = cursor.getString(cursor.getColumnIndex(KEY_DATA1))
                    dataList.add(data)
                }
            } while (cursor.moveToNext())
        }
        cursor.close()
        return dataList
    }

    fun getDataByCity(city: String): ArrayList<String> {
        val dataList = ArrayList<String>()
        val db = this.readableDatabase
        val selectByCityQuery = "SELECT * FROM $TABLE_NAME WHERE $KEY_DATA2 = ?"
        val cursor = db.rawQuery(selectByCityQuery, arrayOf("varela"))
        if (cursor.moveToFirst()) {
            do {
                val data = cursor.getString(cursor.getColumnIndex(KEY_DATA1))
                dataList.add(data)
                val data2 = cursor.getString(cursor.getColumnIndex(KEY_DATA2))
                dataList.add(data2)
                val data3 = cursor.getString(cursor.getColumnIndex(KEY_DATA3))
                dataList.add(data3)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return dataList
    }
}