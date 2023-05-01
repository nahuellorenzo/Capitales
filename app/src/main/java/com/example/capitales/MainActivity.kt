package com.example.capitales

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import android.widget.TextView
import android.widget.Toast
import android.content.Intent

class MainActivity : ComponentActivity() {

    private lateinit var databaseHandler: DatabaseHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn = findViewById<Button>(R.id.button)
        val btn3 = findViewById<Button>(R.id.button3)
        val btnBorrar = findViewById<Button>(R.id.button5)
        val btnModificar = findViewById<Button>(R.id.button7)

        databaseHandler = DatabaseHandler(this)

        btn.setOnClickListener{
            var pais = findViewById<TextView>(R.id.editTextText).text.toString()
            var ciudadCapital = findViewById<TextView>(R.id.editTextText2).text.toString()
            var poblacion = findViewById<TextView>(R.id.editTextText3).text.toString()
            if (pais.isNotEmpty() && ciudadCapital.isNotEmpty() && poblacion.isNotEmpty())
            {
                val result = databaseHandler.addData(pais, ciudadCapital, poblacion.toInt())
                if (result) {
                    Toast.makeText(this, "Se guardo la data exitosamente", Toast.LENGTH_SHORT).show()
                    findViewById<TextView>(R.id.editTextText).setText("")
                    findViewById<TextView>(R.id.editTextText2).setText("")
                    findViewById<TextView>(R.id.editTextText3).setText("")
                } else {
                    Toast.makeText(this, "Error al guardar la data", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        btn3.setOnClickListener{
            val intent = Intent(this, Consultar::class.java)
            startActivity(intent)
        }

        btnBorrar.setOnClickListener{
            val intent2 = Intent(this, Borrar::class.java)
            startActivity(intent2)
        }

        btnModificar.setOnClickListener{
            val intent = Intent(this, Modificar::class.java)
            startActivity(intent)
        }

    }
}