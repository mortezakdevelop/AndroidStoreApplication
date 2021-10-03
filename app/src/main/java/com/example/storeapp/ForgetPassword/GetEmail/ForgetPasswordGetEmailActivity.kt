package com.example.storeapp.ForgetPassword.GetEmail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.storeapp.Components.BaseActivity
import com.example.storeapp.Components.showToast
import com.example.storeapp.Dialog.NoInternet.NoInternetActivity
import com.example.storeapp.ForgetPassword.VerificationEmail.ForgetPasswordVerificationActivity
import com.example.storeapp.R
import com.example.storeapp.databinding.ActivityForgetPasswordGetEmailBinding

class ForgetPasswordGetEmailActivity : BaseActivity() {
    private lateinit var binding: ActivityForgetPasswordGetEmailBinding
    private lateinit var email: String

    private val checkEmailPattern: String = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind()
        binding.btnGetEmail.setOnClickListener {

                getEmail()
                if (checkEmail()) {
                    // all things is true
                    sendVerificationCode()
                }
            }

        }


    private fun bind() {
        binding = ActivityForgetPasswordGetEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getEmail() {
        email = binding.etInputGetEmail.text.toString()
    }

    private fun checkEmail():Boolean{
        if (email.isEmpty()){
            //email is empty
            showToast(this,"please input email")
            return false
        }else{
            // email is not empty and we should check valid input email
            if (validateEmail(email)){
                // email is valid
                return true
            }else{
                showToast(this,"please input valid email")
                return false
            }
        }
    }

    private fun validateEmail(eml:String):Boolean{
       return eml.matches(checkEmailPattern.toRegex())
    }

    // when it is ok go to change password activity( we should use retrofit here but use intent )
    fun sendVerificationCode(){
        val intent = Intent(this,ForgetPasswordVerificationActivity::class.java)
        startActivity(intent)
    }
}