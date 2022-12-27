package com.example.eindosat

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class TopupActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topup)

        val t = findViewById<TextView>(R.id.top1)
        t.setOnClickListener{startActivity(Intent(this@TopupActivity, Topup1::class.java))}

        val bt = findViewById<Button>(R.id.pilih)
        bt.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                showDialog()
            }
        })
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottomsheetlayout)
//
        val editLayout: LinearLayout = dialog.findViewById(R.id.layoutEdit)
        val shareLayout: LinearLayout = dialog.findViewById(R.id.layoutShare)
        val uploadLayout: LinearLayout = dialog.findViewById(R.id.layoutUpload)
        val printLayout: LinearLayout = dialog.findViewById(R.id.layoutPrint)

        editLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this@TopupActivity, "Edit is Clicked", Toast.LENGTH_SHORT).show()
        }

        shareLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this@TopupActivity, "Share is Clicked", Toast.LENGTH_SHORT).show()
        }

        uploadLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this@TopupActivity, "Upload is Clicked", Toast.LENGTH_SHORT).show()
        }

        printLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this@TopupActivity, "Print is Clicked", Toast.LENGTH_SHORT).show()
        }

        dialog.show()
        dialog.getWindow()
            ?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.getWindow()?.getAttributes()?.windowAnimations = R.style.DialogAnimation
        dialog.getWindow()?.setGravity(Gravity.BOTTOM)
    }
}