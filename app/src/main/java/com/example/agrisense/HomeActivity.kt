package com.example.agrisense

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnAskQuery = findViewById<Button>(R.id.btnAskQuery)
        val btnHistory = findViewById<Button>(R.id.btnHistory)

        btnAskQuery.setOnClickListener {
            // TODO: Open QueryActivity
        }

        btnHistory.setOnClickListener {
            // TODO: Open HistoryActivity
        }
    }
}
