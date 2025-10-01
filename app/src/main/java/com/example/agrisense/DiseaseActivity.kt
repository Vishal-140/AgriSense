package com.example.agrisense

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DiseaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disease)

        // bottom navigation
        setupBottomNavigation(this)
    }
}
