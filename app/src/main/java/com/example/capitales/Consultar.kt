package com.example.capitales

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.capitales.R
import android.view.View

class Consultar : ComponentActivity() {

    private lateinit var databaseHandler: DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar)

        databaseHandler = DatabaseHandler(this)

        var btn = findViewById<Button>(R.id.button3)

        btn.setOnClickListener{
            var consul = findViewById<TextView>(R.id.editTextTextConsulta).text.toString().trim()
            val datalist = databaseHandler.getDataByCity(consul)
            val exito = findViewById<TextView>(R.id.textView5)
            val pais = findViewById<TextView>(R.id.textView6)
            val capital = findViewById<TextView>(R.id.textView7)
            val poblacion = findViewById<TextView>(R.id.textView8)
            if (datalist != null){
                exito.visibility = View.VISIBLE
                pais.text = "Pais: ${datalist[0]}"
                pais.visibility = View.VISIBLE
                capital.text = "Capital: ${datalist[1]}"
                capital.visibility = View.VISIBLE
                poblacion.text = "Población: ${datalist[2]}"
                poblacion.visibility = View.VISIBLE
            }
            else
            {
                exito.visibility = View.INVISIBLE
                pais.text = "Pais: "
                pais.visibility = View.INVISIBLE
                capital.text = "Ciudad: "
                capital.visibility = View.INVISIBLE
                poblacion.text = "Poblacion: "
                poblacion.visibility = View.INVISIBLE
                Toast.makeText(this, "No se encontro la capital", Toast.LENGTH_SHORT).show()
            }
        }

        var atras = findViewById<Button>(R.id.button2)

        atras.setOnClickListener{
            val intent_2: Intent = Intent(this, MainActivity:: class.java)
            startActivity(intent_2)
        }
    }
}