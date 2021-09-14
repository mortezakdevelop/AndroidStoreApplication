package com.example.storeapp.Activity.SignUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.storeapp.Components.BaseActivity
import com.example.storeapp.Components.showToast
import com.example.storeapp.Dialog.NoInternet.NoInternetActivity
import com.example.storeapp.R
import com.example.storeapp.databinding.ActivitySignUpBinding

class SignUpActivity : BaseActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var email:String
    private lateinit var password:String
    private lateinit var confirmPassword:String
    private val emailPattern = "[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind()
        context = this
        binding.btnSignup.setOnClickListener{
            if (checkNetwork()){
                // connection is ok
               doSignup()
            }else{
                // client have not internet
                val intent = Intent(context,NoInternetActivity::class.java)
                startActivity(intent)
            }

        }
    }


    // bind layout with viewBinding
    fun bind() {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // get username(email) from client
    private fun getEmail(){
        email = binding.etInputEmailSignup.text.toString()
    }

    //get password from client
    private fun getPassword(){
        password = binding.etInputPasswordSignup.text.toString()
    }

    // get confirm password from client
    private fun getConfirmPassword(){
        confirmPassword = binding.etInputConfirmPasswordSignup.text.toString()
    }

    // check correct input username(email)
    private fun checkEmail():Boolean{
        if (email.length == 0){
            // error --> email is empty
                showToast(context,"email is empty")
            return false
        }else{
            // email fill by client
            return if(validateEmail(email)){
                //true --> email is valid
                true
            }else{
                //false --> email is invalid
                showToast(context,"email is invalid")
                false
            }
        }

    }

    // check correct input password
    private fun checkPassword():Boolean{
        return if(password.isEmpty()){
            // error --> password is empty
            showToast(context,"password is empty")
            false
        }else{
            // input min password size
            if(password.length>=6){
                true
            }else{
                // false --> password size is not correct
                showToast(context,"password size is not correct")
                false
            }
        }
    }

    // check correct email with regex
    private fun validateEmail(eml:String):Boolean{
        return eml.matches(emailPattern.toRegex())
    }

    private fun checkConfirmPassword():Boolean{
        if (confirmPassword.isEmpty()){
            // error --> confirm password is empty
                showToast(context,"confirm password is empty")
            return false
        }else{

            return confirmPassword.equals(password)
        }
    }

    private fun doSignup(){
        getEmail()
        if(checkEmail()){
            getPassword()
            if (checkPassword()){
                getConfirmPassword()
                if (checkConfirmPassword()){
                    // true --> do sign up
                    showToast(context,"sign up is ok")
                }else{
                    showToast(context,"password and confirm password is not match")
                }
            }
        }
    }
}