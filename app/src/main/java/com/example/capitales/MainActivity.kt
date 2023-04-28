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

        databaseHandler = DatabaseHandler(this)

        btn.setOnClickListener{
            Toast.makeText(this, "Sos un capo", Toast.LENGTH_SHORT).show();
            var pais = findViewById<TextView>(R.id.editTextText).text.toString()
            var ciudadCapital = findViewById<TextView>(R.id.editTextText2).text.toString()
            var poblacion = findViewById<TextView>(R.id.editTextText3).text.toString().toInt()
            val result = databaseHandler.addData(pais, ciudadCapital, poblacion)
            if (result) {
                Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show()
                findViewById<TextView>(R.id.editTextText).setText("")
                findViewById<TextView>(R.id.editTextText).hint = "Pais"
            } else {
                Toast.makeText(this, "Failed to save data", Toast.LENGTH_SHORT).show()
            }
        }

        btn3.setOnClickListener{
            val intent = Intent(this, Consultar::class.java)
            startActivity(intent)
        }
    }
}