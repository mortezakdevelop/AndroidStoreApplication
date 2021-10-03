package com.example.storeapp.ForgetPassword.VerificationEmail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.storeapp.Components.BaseActivity
import com.example.storeapp.Components.showToast
import com.example.storeapp.Dialog.NoInternet.NoInternetActivity
import com.example.storeapp.ForgetPassword.GetPassword.ForgetPasswordCreateNewPasswordActivity
import com.example.storeapp.R
import com.example.storeapp.databinding.ActivityForgetPasswordVerificationBinding

class ForgetPasswordVerificationActivity : BaseActivity() {

    private lateinit var binding: ActivityForgetPasswordVerificationBinding
    private lateinit var password: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind()
        binding.btnVerifyEmail.setOnClickListener{

                getPassword()
                if(checkPassword()){
                    // all is ok and send verification code to validate in server
                    sendCodeForValidation()

                }
        }
        
    }

    private fun bind() {
        binding = ActivityForgetPasswordVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getPassword() {
        password = binding.etInputVerifyEmail.text.toString()
    }

    private fun checkPassword(): Boolean {
        if (password.isEmpty()) {
            // password is empty
            showToast(this, "verification code is empty")
            return false
        } else {
            if (validPassword(password)) {
                // all is ok
                return true
            } else {
                showToast(this, "input valid email")
                return false
            }


        }

    }
    // send just a six character code to user
    private fun validPassword(password:String):Boolean{
        return if (password.length == 6){
            true
        }else{
            showToast(this,"input valid verification code")
            false
        }
    }

    // this part connect to database and retrofit
    private fun sendCodeForValidation(){
        val intent = Intent(this,ForgetPasswordCreateNewPasswordActivity::class.java)
        startActivity(intent)

    }
}