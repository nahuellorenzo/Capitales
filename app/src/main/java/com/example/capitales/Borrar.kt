package com.example.capitales

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.capitales.R

class Borrar : ComponentActivity() {

    private lateinit var databaseHandler: DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrar)

        databaseHandler = DatabaseHandler(this)

        val btn = findViewById<Button>(R.id.button4)

        btn.setOnClickListener{
            val city = findViewById<EditText>(R.id.editTextText8).text.toString()
            if (city.isNotEmpty()){
                val res = databaseHandler.deleteByCity(city)
                if (res !== 0 )
                {
                    Toast.makeText(this, "Ciudad eliminada", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(this, "La ciudad ingresada no existe", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "Introduce una ciudad para eliminar", Toast.LENGTH_LONG).show()
            }
        }
    }
}