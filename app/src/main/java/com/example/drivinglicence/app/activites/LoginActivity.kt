package com.example.drivinglicence.app.activites

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.drivinglicence.databinding.LoginActivityBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: LoginActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val savedEmail = sharedPreferences.getString("EMAIL", "")
            val savedPassword = sharedPreferences.getString("PASSWORD", "")

            if (email == savedEmail && password == savedPassword) {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

                // Chuyển sang HomeActivity sau khi đăng nhập thành công
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()  // Đóng LoginActivity để không quay lại màn hình đăng nhập
            } else {
                Toast.makeText(this, "Invalid credentials!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvRegister.setOnClickListener {
            // Chuyển sang RegisterActivity khi người dùng nhấn vào liên kết đăng ký
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
