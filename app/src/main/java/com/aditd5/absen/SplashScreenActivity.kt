package com.aditd5.absen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.aditd5.absen.databinding.ActivitySplashScreenBinding
import com.aditd5.absen.util.Prefs

private lateinit var binding: ActivitySplashScreenBinding
private var statusLogin = false

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sp = Prefs(this)

        Handler().postDelayed({
            if (sp.getIsLogin()) {      //jika true akah mengarah ke home
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        },3000)
    }
}