package com.example.capitales

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.capitales.R

class Modificar : ComponentActivity() {

    private lateinit var databaseHandler: DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar)

        databaseHandler = DatabaseHandler(this)

        var btn = findViewById<Button>(R.id.button8)

        btn.setOnClickListener{
            val city = findViewById<TextView>(R.id.editTextText10).text.toString().trim()
            val population = findViewById<TextView>(R.id.editTextText11).text.toString().trim()
            if (city.isNotEmpty() && population.isNotEmpty()){
                val resp = databaseHandler.updatePopulation(city, population.toInt())
                if (resp != 0){
                    Toast.makeText(this, "Poblacion de "+city+" modificada", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "La ciudad ingresada no existe", Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        var atras = findViewById<Button>(R.id.button2)

        atras.setOnClickListener{
            val intent_2: Intent = Intent(this, MainActivity:: class.java)
            startActivity(intent_2)
        }

    }
}