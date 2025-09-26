package com.example.agrisense

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val btnSignup = findViewById<Button>(R.id.btnSignup)
        val Login = findViewById<TextView>(R.id.loginLink)

        btnSignup.setOnClickListener {
            // TODO: Add signup logic (Firebase / local storage)
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        Login.setOnClickListener {
            // Navigate back to LoginActivity
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
