package com.example.storeapp.Activity.SignUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.storeapp.Components.showToast
import com.example.storeapp.R
import com.example.storeapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind()
    }
    // bind layout with viewBinding
    fun bind() {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}