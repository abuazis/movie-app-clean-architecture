package com.abuzaio.native_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ArchitectActivity : AppCompatActivity() {
    // onCreate adalah fungsi yang akan dijalankan
    // ketika aplikasi dijalankan
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_architect)
    }
    // onPause adalah fungsi yang akan dijalankan
    // ketika user menekan tombol home
    override fun onPause() {
        super.onPause()
    }

    // onResume adalah fungsi yang akan dijalankan
    // ketik user meng-click kembali setelah menekan tombol home
    override fun onResume() {
        super.onResume()
    }

    // onDestroy adalah fungsi yang akan dipanggil
    // ketika user menekan tombol back
    override fun onDestroy() {
        super.onDestroy()
    }
}