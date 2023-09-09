package com.aditd5.absen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aditd5.absen.databinding.ActivityScannerBinding

private lateinit var binding: ActivityScannerBinding

class ScannerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScannerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}