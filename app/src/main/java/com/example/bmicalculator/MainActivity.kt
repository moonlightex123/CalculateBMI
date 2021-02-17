package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enterBtn = findViewById<Button>(R.id.enterBtn)

        enterBtn.setOnClickListener {
            val intent = Intent(this,BMI::class.java)

            val personName = findViewById<TextView>(R.id.nameText).text
            intent.putExtra("personName",personName.toString())

            startActivity(intent)
        }
    }
}