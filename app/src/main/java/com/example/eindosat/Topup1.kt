package com.example.eindosat

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Topup1 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topup1)

        val t = findViewById<TextView>(R.id.top2)
        t.setOnClickListener{startActivity(Intent(this@Topup1, Topup2::class.java))}
    }
}