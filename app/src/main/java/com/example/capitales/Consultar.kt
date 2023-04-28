package com.example.capitales

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.capitales.R

class Consultar : ComponentActivity() {

    private lateinit var databaseHandler: DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar)

        databaseHandler = DatabaseHandler(this)

        var btn = findViewById<Button>(R.id.button2)

        btn.setOnClickListener{
            var consul = findViewById<TextView>(R.id.editTextText4).text.toString()
            val datalist = databaseHandler.getDataByCity(consul)
            if (datalist != null){
                findViewById<TextView>(R.id.editTextText5).setText(datalist[0] as String)
                findViewById<TextView>(R.id.editTextText6).setText(datalist[1] as String)
                findViewById<TextView>(R.id.editTextText7).setText(datalist[2].toString())
            }
            else
            {
                Toast.makeText(this, "No se encontro la capital", Toast.LENGTH_SHORT).show()
            }
        }
    }
}