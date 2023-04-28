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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var pais = findViewById<TextView>(R.id.editTextText)
        var ciudadCapital = findViewById<TextView>(R.id.editTextText2)
        var poblacion = findViewById<TextView>(R.id.editTextText3)
        var btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener{
            Toast.makeText(this, "Sos un capo", Toast.LENGTH_SHORT).show();
            pais.setText("nahuel");
        }
    }
}