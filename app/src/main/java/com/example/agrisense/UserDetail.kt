package com.example.agrisense

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UserDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_detail)

        val submitButton = findViewById<Button>(R.id.submitButton)
        val confirmCheckBox = findViewById<CheckBox>(R.id.confirmCheckBox)

        // Enable submit button only if checkbox is checked
        confirmCheckBox.setOnCheckedChangeListener { _, isChecked ->
            submitButton.isEnabled = isChecked
        }

        submitButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
