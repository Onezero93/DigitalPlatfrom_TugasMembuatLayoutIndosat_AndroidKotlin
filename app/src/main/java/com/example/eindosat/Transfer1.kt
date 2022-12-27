package com.example.eindosat

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class Transfer1 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer1)

        val bt = findViewById<Button>(R.id.btn_tranfer)
        bt.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                showDialog()
            }
        })
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottomsheetlayout2)
//
        val editLayout: LinearLayout = dialog.findViewById(R.id.layoutdialog)
        val shareLayout: LinearLayout = dialog.findViewById(R.id.layoutdialog1)

        editLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this@Transfer1, "Edit is Clicked", Toast.LENGTH_SHORT).show()
        }

        shareLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this@Transfer1, "Share is Clicked", Toast.LENGTH_SHORT).show()
        }

        dialog.show()
        dialog.getWindow()
            ?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.getWindow()?.getAttributes()?.windowAnimations = R.style.DialogAnimation
        dialog.getWindow()?.setGravity(Gravity.BOTTOM)
    }
}