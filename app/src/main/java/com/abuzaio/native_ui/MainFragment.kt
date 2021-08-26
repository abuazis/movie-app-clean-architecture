package com.abuzaio.native_ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainFragment : Fragment() {
    // onCreateView fungsi yang dijalankan ketika
    // activity sudah di inflate dan fragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater
            .from(context)
            .inflate(R.layout.fragment_main, container, false);
    }

    // onViewCreated fungsi yang dijalankan ketika
    // fragment sudah dipanggil dan kita ingin menginisialisasi
    // salah satu di dalam fragment variabel yang ada
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    // onDestroyView fungsi yang akan dijalankan ketika
    // activity yang telah dibuka lalu ditutup kembali
    override fun onDestroyView() {
        super.onDestroyView()
    }
}