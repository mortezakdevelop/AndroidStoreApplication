package com.example.storeapp.ForgetPassword.GetPassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.storeapp.Activity.Login.LoginActivity
import com.example.storeapp.Components.BaseActivity
import com.example.storeapp.Components.showToast
import com.example.storeapp.Dialog.NoInternet.NoInternetActivity
import com.example.storeapp.R
import com.example.storeapp.databinding.ActivityForgetPasswordCreateNewPasswordBinding
import com.example.storeapp.databinding.ActivityForgetPasswordGetEmailBinding

class ForgetPasswordCreateNewPasswordActivity : BaseActivity() {
    private lateinit var password: String
    private lateinit var confirmPassword: String

    private lateinit var binding: ActivityForgetPasswordCreateNewPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind()
        binding.btnVerifyNewPassword.setOnClickListener {

                getPassword()
                if (checkPassword()) {
                    getConfirmPassword()
                    if (checkConfirmPassword()){
                        // true and all is ok and send new password to server
                        submitNewPassword()
                    }

                }
        }

    }

    private fun bind() {
        binding = ActivityForgetPasswordCreateNewPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getPassword() {
        password = binding.etInputCreateNewPassword.text.toString()
    }

    private fun getConfirmPassword() {
        confirmPassword = binding.etInputConfirmNewPassword.text.toString()
    }

    private fun checkPassword(): Boolean {
        if (password.isEmpty()) {
            // show password is empty
            showToast(this, "password is empty")
            return true
        } else {
            return if (password.length >= 6) {
                // all is ok
                true
            } else {
                showToast(this, "please input validate password")
                false
            }
        }
    }
    private fun checkConfirmPassword():Boolean{
        if(confirmPassword.isEmpty()){
            // confirm password is empty
            showToast(this,"confirm password is empty")
            return false
        }else{
            if (confirmPassword.equals(password)){
                showToast(this,"ok")
                return true
            }else{
                showToast(this,"password and confirm password is not match")
                return false
            }
        }

    }
    private fun submitNewPassword(){
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }

}