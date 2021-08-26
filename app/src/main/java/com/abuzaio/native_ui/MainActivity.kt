package com.abuzaio.native_ui

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set on click listener for click button (show toast)
        val button = findViewById<Button>(R.id.btn_click)
        button.setOnClickListener {
            Toast.makeText(this, "Ohayou Sekai, Good Morning World!", Toast.LENGTH_SHORT).show()
        }

        // set on click listener for snack button (show snackbar)
        val rootLayout = findViewById<LinearLayout>(R.id.root_layout)
        val buttonSnack = findViewById<Button>(R.id.btn_snackbar)
        buttonSnack.setOnClickListener {
            Snackbar.make(rootLayout, "Snack Crackers", Snackbar.LENGTH_SHORT).show()
        }

        // add fragment to this activity
        supportFragmentManager.beginTransaction().replace(R.id.fl_main, MainFragment()).commit()
    }
}