package com.example.agrisense

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch


class Recommendation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recommendation)

        val tempSpinner = findViewById<Spinner>(R.id.tempSpinner)
        val humiditySpinner = findViewById<Spinner>(R.id.humiditySpinner)
        val soilSpinner = findViewById<Spinner>(R.id.soilSpinner)

        val recommendBtn = findViewById<Button>(R.id.recommendBtn)
        val resultCard = findViewById<CardView>(R.id.resultCard)
        val resultText = findViewById<TextView>(R.id.resultText)

        recommendBtn.setOnClickListener {

            val temp = tempSpinner.selectedItem.toString()
            val humidity = humiditySpinner.selectedItem.toString()
            val soil = soilSpinner.selectedItem.toString()

            resultText.text = "Loading..."
            resultCard.visibility = View.VISIBLE

            // Call AI
            lifecycleScope.launch {

                try {
                    val aiResponse = GeminiHelper.getCrop(temp, humidity, soil)
                    resultText.text = aiResponse

                } catch (e: Exception) {
                    resultText.text = "Error: ${e.message}"
                }
            }
        }
        resultCard.visibility = View.VISIBLE
    }
}
