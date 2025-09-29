package com.example.agrisense

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val drawer_layout:DrawerLayout = findViewById(R.id.drawer_layout)
        val drawer_button:View = findViewById(R.id.drawer_menu_icon)


        drawer_button.setOnClickListener {
            drawer_layout.open()
        }

    }
}