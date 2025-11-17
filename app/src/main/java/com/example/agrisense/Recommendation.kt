package com.example.agrisense

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

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

            val (crop, description) = when {

                temp.contains("20°C - 30°C") && soil.contains("Loamy") ->
                    "Wheat" to "Wheat grows well in loamy soil and needs mild temperature."

                temp.contains("30°C - 40°C") && soil.contains("Black Soil") ->
                    "Cotton" to "Cotton loves black soil and hot temperature."

                humidity.contains("60% - 80%") && soil.contains("Clay") ->
                    "Rice" to "Rice requires high moisture and clay soil."

                temp.contains("18°C - 28°C") && soil.contains("Loamy") ->
                    "Maize" to "Maize grows well in warm weather and loamy soil."

                temp.contains("25°C - 35°C") && soil.contains("Sandy") ->
                    "Groundnut" to "Groundnut prefers sandy soil and warm climate."

                temp.contains("22°C - 28°C") && humidity.contains("50% - 70%") ->
                    "Tomato" to "Tomato grows well in medium humidity and warm temperature."

                temp.contains("15°C - 25°C") && soil.contains("Clay") ->
                    "Potato" to "Potato needs cool climate and clay soil."

                temp.contains("25°C - 32°C") && soil.contains("Alluvial") ->
                    "Sugarcane" to "Sugarcane grows best in fertile alluvial soil."

                temp.contains("28°C - 38°C") && humidity.contains("70% - 90%") ->
                    "Banana" to "Banana requires hot climate and high humidity."

                temp.contains("12°C - 18°C") && soil.contains("Loamy") ->
                    "Barley" to "Barley grows in cool weather and loamy soil."

                temp.contains("20°C - 27°C") && soil.contains("Red Soil") ->
                    "Millet (Bajra)" to "Bajra grows well in red soil and warm climate."

                temp.contains("25°C - 35°C") && humidity.contains("30% - 50%") ->
                    "Soybean" to "Soybean needs warm conditions and moderate humidity."

                temp.contains("10°C - 20°C") && soil.contains("Sandy") ->
                    "Carrot" to "Carrot grows best in cool weather and sandy soil."

                temp.contains("22°C - 30°C") && soil.contains("Black Soil") ->
                    "Sunflower" to "Sunflower grows well in hot climate and black soil."

                temp.contains("15°C - 22°C") && soil.contains("Loamy") ->
                    "Peas" to "Peas need cool temperature and loamy soil."

                temp.contains("20°C - 26°C") && soil.contains("Alluvial") ->
                    "Mustard" to "Mustard grows in cool climate and fertile soil."

                temp.contains("18°C - 24°C") && humidity.contains("40% - 60%") ->
                    "Onion" to "Onion grows well in moderate climate and humidity."

                temp.contains("16°C - 25°C") && soil.contains("Sandy") ->
                    "Garlic" to "Garlic prefers cool temperature and sandy soil."

                temp.contains("22°C - 30°C") && soil.contains("Red Soil") ->
                    "Sorghum (Jowar)" to "Jowar grows well in red soil with warm climate."

                temp.contains("24°C - 34°C") && soil.contains("Alluvial") ->
                    "Paddy" to "Paddy grows well in alluvial soil and warm climate."

                temp.contains("26°C - 36°C") && soil.contains("Black Soil") ->
                    "Tobacco" to "Tobacco needs warm temperature and black soil."

                temp.contains("14°C - 22°C") && soil.contains("Clay") ->
                    "Cabbage" to "Cabbage grows best in cool climate and clay soil."

                temp.contains("18°C - 28°C") && soil.contains("Clay") ->
                    "Cauliflower" to "Cauliflower needs cool to warm climate and clay soil."

                temp.contains("20°C - 32°C") && humidity.contains("50% - 70%") ->
                    "Papaya" to "Papaya grows well in warm climate with medium humidity."

                temp.contains("28°C - 36°C") && soil.contains("Sandy") ->
                    "Watermelon" to "Watermelon grows in hot climate and sandy soil."

                temp.contains("25°C - 32°C") && soil.contains("Red Soil") ->
                    "Ragi" to "Ragi grows in red soil and warm conditions."

                temp.contains("18°C - 30°C") && soil.contains("Alluvial") ->
                    "Chickpea" to "Chickpea grows best in cool to warm climate."

                temp.contains("20°C - 35°C") && soil.contains("Loamy") ->
                    "Green Gram (Moong)" to "Moong grows in warm climate and loamy soil."

                temp.contains("20°C - 35°C") && soil.contains("Sandy") ->
                    "Black Gram (Urad)" to "Urad grows well in sandy soil and warm conditions."

                else ->
                    "Mixed Vegetables" to "These conditions support general vegetable growth."
            }


            resultText.text = "Best Crop: $crop\n\nDescription: $description"
            resultCard.visibility = View.VISIBLE
        }
    }
}
