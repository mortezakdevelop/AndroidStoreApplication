package com.example.storeapp.Activity.Splash

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.bumptech.glide.Glide
import com.example.storeapp.Activity.Login.LoginActivity
import com.example.storeapp.Components.BaseActivity
import com.example.storeapp.Dialog.NoInternet.NoInternetActivity
import com.example.storeapp.R
import com.example.storeapp.databinding.ActivitySplashBinding
import io.github.inflationx.viewpump.ViewPumpContextWrapper




class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var anim: Animation
    // time for delay to show splash activity
    private val TIME_OUT :Long = 5000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        viewBinding()
        defineAnimation()
        setLogo()
        loadAnimation()
        showSplash()
    }

    //اگر کاربر اینترنت داشت اسپلش را نشان نمی دهد. برای حل این مشکل یه تایم به آن می دهیم تا اسپلش را در تایم تعیین شده نمایش دهد
    fun showSplash(){
      Handler().postDelayed({
          if(checkNetwork()){
              // go to login
              val intent = Intent(this,LoginActivity::class.java)
              startActivity(intent)
          }else{
              val intent = Intent(this,NoInternetActivity::class.java)
              startActivity(intent)
          }
      },TIME_OUT)
    }



    // bind views
    private fun viewBinding() {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // load logo in drawable with glide library
    private fun setLogo() {
        Glide.with(this).load(R.drawable.ic_logo).into(binding.ivLogoSplash)
    }

    private fun defineAnimation() {
        anim = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
    }

    private fun loadAnimation() {
        binding.ivLogoSplash.startAnimation(anim)
        binding.tvSloganSplash.startAnimation(anim)
        binding.tvWebSiteSplash.startAnimation(anim)
    }
}