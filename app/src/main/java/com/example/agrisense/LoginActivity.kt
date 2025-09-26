package com.example.agrisense

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val Signup = findViewById<TextView>(R.id.signupLink)

        btnLogin.setOnClickListener {
            // TODO: Add authentication logic here
            startActivity(Intent(this, HomeActivity::class.java))
            finish() // so user can't come back to login by back button
        }

        Signup.setOnClickListener {
            // Navigate to SignupActivity
            startActivity(Intent(this, SignupActivity::class.java))
            finish() // optional, prevents back to login
        }
    }
}
