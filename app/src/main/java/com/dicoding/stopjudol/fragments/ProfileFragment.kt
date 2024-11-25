package com.dicoding.stopjudol.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.dicoding.stopjudol.LoginActivity
import com.dicoding.stopjudol.R
import com.dicoding.stopjudol.SettingsActivity

class ProfileFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout for the fragment
        val rootView = inflater.inflate(R.layout.fragment_profile, container, false)

        sharedPreferences = requireActivity().getSharedPreferences("user_session", Context.MODE_PRIVATE)

        // Ambil data nama dan email dari SharedPreferences
        val userName = sharedPreferences.getString("name", "User Tidak Dikenal")
        val userEmail = sharedPreferences.getString("email", "user@example.com")

        // Tampilkan nama dan email di TextView
        val tvProfileName = rootView.findViewById<TextView>(R.id.tv_profile_name)
        val tvProfileEmail = rootView.findViewById<TextView>(R.id.tv_profile_email)
        tvProfileName.text = "Nama: $userName"
        tvProfileEmail.text = "Email: $userEmail"

        // Tombol Setting
        val btnSetting = rootView.findViewById<Button>(R.id.btn_setting)
        btnSetting.setOnClickListener {
            // Navigasi ke SettingsActivity (buat SettingsActivity jika belum ada)
            val intent = Intent(activity, SettingsActivity::class.java)
            startActivity(intent)
        }

        // Tombol Logout
        val btnLogout = rootView.findViewById<Button>(R.id.btn_logout)
        btnLogout.setOnClickListener {
            logout()
        }

        return rootView
    }

    private fun logout() {
        // Hapus data sesi
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()

        // Arahkan kembali ke LoginActivity
        val intent = Intent(activity, LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }
}
