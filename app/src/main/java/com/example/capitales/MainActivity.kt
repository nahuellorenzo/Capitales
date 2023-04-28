package com.example.capitales

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.capitales.ui.theme.CapitalesTheme
import android.widget.TextView
import android.widget.Toast

class MainActivity : ComponentActivity() {

    private lateinit var databaseHandler: DatabaseHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn = findViewById<Button>(R.id.button)

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
    }
}