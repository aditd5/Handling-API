package com.aditd5.absen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aditd5.absen.databinding.ActivityMainBinding
import com.aditd5.absen.util.Prefs

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnScan.setOnClickListener {
            startActivity(Intent(this, ScannerActivity::class.java))
        }

        val sp = Prefs(this)
        binding.btnLogout.setOnClickListener {
            sp.setIsLogin(false)
        }
    }
}