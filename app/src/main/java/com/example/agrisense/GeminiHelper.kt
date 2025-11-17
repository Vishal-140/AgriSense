package com.example.agrisense

import com.google.ai.client.generativeai.GenerativeModel

object GeminiHelper {

    private const val API_KEY = "YOUR_API_KEY"

    private val model = GenerativeModel(
        modelName = "models/gemini-2.5-pro",
        apiKey = API_KEY
    )

    suspend fun getCrop(temp: String, humidity: String, soil: String): String {

        val prompt = """
            Suggest the multiple best crop for:
            Temperature: $temp
            Humidity: $humidity
            Soil: $soil

            Reply in one to two short line only.
            Format: Crop - Reason.
        """.trimIndent()

        val response = model.generateContent(prompt)

        return response.text ?: "No response from AI"
    }
}
