package com.example.capitales

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
        val btnPais = findViewById<Button>(R.id.button6)

        btn.setOnClickListener{
            val city = findViewById<EditText>(R.id.editTextText8).text.toString().trim()
            if (city.isNotEmpty()){
                val res = databaseHandler.deleteByCity(city)
                if (res != 0 )
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

        btnPais.setOnClickListener{
            val pais = findViewById<EditText>(R.id.editTextText9).text.toString().trim()
            if (pais.isNotEmpty()){
                val res = databaseHandler.deleteByCountry(pais)
                if (res != 0 )
                {
                    Toast.makeText(this, "Ciudades de "+pais+" elimiandas", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(this, "No se encontro ciudades del pais ingresado", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "Introduce un pais para eliminar sus ciudades", Toast.LENGTH_LONG).show()
            }
        }

        var atras = findViewById<Button>(R.id.button2)

        atras.setOnClickListener{
            val intent_2: Intent = Intent(this, MainActivity:: class.java)
            startActivity(intent_2)
        }
    }
}