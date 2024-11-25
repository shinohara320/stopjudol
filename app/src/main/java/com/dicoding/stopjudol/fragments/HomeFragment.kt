package com.dicoding.stopjudol.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.dicoding.stopjudol.LoginActivity
import com.dicoding.stopjudol.R
import android.content.SharedPreferences

class HomeFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout for the fragment
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        sharedPreferences = requireActivity().getSharedPreferences("user_session", Context.MODE_PRIVATE)

        // Ambil data nama pengguna yang disimpan di SharedPreferences
        val userName = sharedPreferences.getString("email", "User Tidak Dikenal")

        // Menampilkan nama pengguna di TextView
        val tvUserInfo = rootView.findViewById<TextView>(R.id.tvUserInfo)
        tvUserInfo.text = "Selamat datang, $userName!"

        // Tombol logout
        val btnLogout = rootView.findViewById<Button>(R.id.btn_logout)
        btnLogout.setOnClickListener {
            logout()
        }

        return rootView
    }

    private fun logout() {
        // Hapus data sesi (username, nama pengguna, dll)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()

        // Arahkan kembali ke LoginActivity
        val intent = Intent(activity, LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }
}