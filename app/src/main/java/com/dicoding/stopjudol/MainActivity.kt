package com.dicoding.stopjudol

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment
import com.dicoding.stopjudol.fragments.HomeFragment
import com.dicoding.stopjudol.fragments.ListFragment
import com.dicoding.stopjudol.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menampilkan Fragment Default (HomeFragment)
        loadFragment(HomeFragment())

        // Ambil instance BottomNavigationView
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Setup Listener untuk Navigasi
        bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment()) // Navigasi ke HomeFragment
                    true
                }
                R.id.nav_list -> {
                    loadFragment(ListFragment()) // Navigasi ke ListFragment
                    true
                }
                R.id.nav_profile -> {
                    loadFragment(ProfileFragment()) // Navigasi ke ProfileFragment
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}

