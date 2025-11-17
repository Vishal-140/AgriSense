package com.example.agrisense

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recommendCard = findViewById<CardView>(R.id.recommendCrop)

        recommendCard.setOnClickListener {
            val intent = Intent(this, Recommendation::class.java)
            startActivity(intent)
        }

        // bottom navigation
        setupBottomNavigation(this)
    }
}
