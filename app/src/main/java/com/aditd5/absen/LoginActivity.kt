package com.aditd5.absen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aditd5.absen.core.data.source.remote.network.State
import com.aditd5.absen.core.data.source.remote.request.LoginRequest
import com.aditd5.absen.databinding.ActivityLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setData()
    }

//    fun testing() {
//        val sp = Prefs(this)
//        binding.btnLogin.setOnClickListener {
//            sp.setIsLogin(true)
//            startActivity(Intent(this, MainActivity::class.java))
//        }
//    }

    private fun setData() {
        viewModel.text.observe(this) {
            binding.etEmail.setText(it)
        }
        binding.btnLogin.setOnClickListener {

            login()
        }
    }

    private fun login() {

        if (binding.etEmail.text!!.isEmpty()) return
        if (binding.etPassword.text!!.isEmpty()) return

        val body = LoginRequest(
            binding.etEmail.text.toString(),
            binding.etPassword.text.toString()
        )

        viewModel.login(body).observe(this) {

            when (it.state) {
                State.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this,"Selamat Datang "  + it.data?.name , Toast.LENGTH_SHORT).show()
                }
                State.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this,it.message?: "Error", Toast.LENGTH_SHORT).show()
                }
                State.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
//            Toast.makeText(this,"Selamat Datang "  + it?.data?.name , Toast.LENGTH_SHORT).show()
        }
    }
}