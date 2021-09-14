package com.example.storeapp.Activity.Login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.storeapp.Components.BaseActivity
import com.example.storeapp.Components.showToast
import com.example.storeapp.Dialog.NoInternet.NoInternetActivity
import com.example.storeapp.R
import com.example.storeapp.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var email: String
    private lateinit var password: String

    //correct format for email with Regex
    private val emailPattern = "[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        bind()
        binding.btnLogin.setOnClickListener{
            if (checkNetwork()){
               sendRequest()

            }else{
                // show no internet dialog
                val intent = Intent(context,NoInternetActivity::class.java)
                startActivity(intent)
            }
        }
    }

    //bind layout viewBinding
    private fun bind() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun sendRequest(){
        getEmail()
        if (checkEmail()){
            // true --> now you can check password
            getPassword()
            if (checkPassword()){
                // true --> now you can send request server
                showToast(context,"now you can send request to server")
            }
        }
    }

    // get username(email) from client
    private fun getEmail() {
        email = binding.etUsernameLogin.text.toString()
    }

    // get password from client
    private fun getPassword() {
        password = binding.etPasswordLogin.text.toString()
    }

    // check correct input username(email)
    private fun checkEmail(): Boolean {
        // error --> username is empty
        return if(email.isEmpty()){
            //error --> username is empty
            showToast(context,"username is empty")
            false
        }else{
            if(validateEmail(email)){
                // true --> email is valid
                true
            }else{
                // false --> email is invalid
                showToast(context,"email is invalid")
                false
            }
        }
    }

    // check correct input password
    private fun checkPassword():Boolean{
        return if (password.isEmpty()){
            //error --> password is empty
            showToast(context,"password is empty")
            false
        }else{
            if(password.length>=6){
                // input min password size
                true
            }else{
                // error --> input correct password size
                showToast(context,"input correct password size")
                false
            }
        }
    }

    // check email format with regex
    private fun validateEmail(eml:String):Boolean{
        return eml.matches(emailPattern.toRegex())

    }
}