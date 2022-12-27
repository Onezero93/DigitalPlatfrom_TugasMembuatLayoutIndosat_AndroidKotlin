package com.example.eindosat

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Transfer : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer)


        val t = findViewById<TextView>(R.id.ovo)
        t.setOnClickListener{startActivity(Intent(this@Transfer, Transfer1::class.java))}
    }
}