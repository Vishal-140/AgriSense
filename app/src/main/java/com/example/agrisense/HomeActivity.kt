package com.example.agrisense

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Bottom Navigation
        val navHome = findViewById<LinearLayout>(R.id.nav_home)
        val navWeather = findViewById<LinearLayout>(R.id.nav_weather)
        val navChat = findViewById<LinearLayout>(R.id.nav_chat)
        val navDiseases = findViewById<LinearLayout>(R.id.nav_diseases)
        val navProfile = findViewById<LinearLayout>(R.id.nav_profile)

        navHome.setOnClickListener {

        }

        navWeather.setOnClickListener {
            val intent = Intent(this@HomeActivity, WeatherActivity::class.java)
            startActivity(intent)
        }

        navChat.setOnClickListener {
            val intent = Intent(this@HomeActivity, ChatActivity::class.java)
            startActivity(intent)
        }

        navDiseases.setOnClickListener {
            val intent = Intent(this@HomeActivity, DiseaseActivity::class.java)
            startActivity(intent)
        }

        navProfile.setOnClickListener {
            val intent = Intent(this@HomeActivity, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}
