package com.example.agrisense

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private val IMAGE_PICK_CODE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setupBottomNavigation(this)

        val userImage = findViewById<ImageView>(R.id.userImage)
        val selectImageButton = findViewById<Button>(R.id.selectImageButton)
        val editDetailsButton = findViewById<Button>(R.id.updateDetailsButton)
        val submitButton = findViewById<Button>(R.id.submitButton)

        val fields = listOf(
            findViewById<EditText>(R.id.name),
            findViewById<EditText>(R.id.number),
            findViewById<EditText>(R.id.district),
            findViewById<EditText>(R.id.state),
            findViewById<EditText>(R.id.country),
            findViewById<EditText>(R.id.farmArea)
        )

        val editEmail = findViewById<EditText>(R.id.email)

        // Load user data
        loadUserProfile(editEmail, fields, userImage)

        // Enable editing
        editDetailsButton.setOnClickListener {
            fields.forEach { it.isEnabled = true }
            selectImageButton.isEnabled = true
            submitButton.isEnabled = true
        }

        // Save updated data
        submitButton.setOnClickListener {
            saveUserProfile(fields, userImage)
            Toast.makeText(this, "Profile updated", Toast.LENGTH_SHORT).show()
            fields.forEach { it.isEnabled = false }
            selectImageButton.isEnabled = false
            submitButton.isEnabled = false
        }

        // Change image
        selectImageButton.setOnClickListener {
            startActivityForResult(Intent(Intent.ACTION_PICK).apply { type = "image/*" }, IMAGE_PICK_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val userImage = findViewById<ImageView>(R.id.userImage)
        if (requestCode == IMAGE_PICK_CODE && resultCode == Activity.RESULT_OK) {
            val imageUri: Uri? = data?.data
            userImage.setImageURI(imageUri)
        }
    }

    private fun loadUserProfile(emailField: EditText, fields: List<EditText>, userImage: ImageView) {
        val prefs = getSharedPreferences("user_prefs", MODE_PRIVATE)
        emailField.setText(prefs.getString("email", ""))
        val keys = listOf("name","phone","district","state","country","farmArea")
        fields.forEachIndexed { index, editText -> editText.setText(prefs.getString(keys[index],"")) }

        prefs.getString("imageUri", null)?.let { userImage.setImageURI(Uri.parse(it)) }
    }

    private fun saveUserProfile(fields: List<EditText>, userImage: ImageView) {
        val keys = listOf("name","phone","district","state","country","farmArea")
        getSharedPreferences("user_prefs", MODE_PRIVATE).edit().apply {
            fields.forEachIndexed { index, editText -> putString(keys[index], editText.text.toString()) }
            apply()
        }
    }
}
