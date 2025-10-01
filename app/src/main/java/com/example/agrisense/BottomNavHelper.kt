package com.example.agrisense

import android.app.Activity
import android.content.Intent
import android.widget.LinearLayout

fun setupBottomNavigation(activity: Activity) {
    val navHome = activity.findViewById<LinearLayout>(R.id.nav_home)
    val navWeather = activity.findViewById<LinearLayout>(R.id.nav_weather)
    val navChat = activity.findViewById<LinearLayout>(R.id.nav_chat)
    val navDiseases = activity.findViewById<LinearLayout>(R.id.nav_diseases)
    val navProfile = activity.findViewById<LinearLayout>(R.id.nav_profile)

    navHome?.setOnClickListener {
        val intent = Intent(activity, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        activity.startActivity(intent)
    }

    navWeather?.setOnClickListener {
        val intent = Intent(activity, WeatherActivity::class.java)
        activity.startActivity(intent)
    }

    navChat?.setOnClickListener {
        val intent = Intent(activity, ChatActivity::class.java)
        activity.startActivity(intent)
    }

    navDiseases?.setOnClickListener {
        val intent = Intent(activity, DiseaseActivity::class.java)
        activity.startActivity(intent)
    }

    navProfile?.setOnClickListener {
        val intent = Intent(activity, ProfileActivity::class.java)
        activity.startActivity(intent)
    }
}
