package com.example.storeapp.Dialog.NoInternet

import android.content.ComponentName
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.core.view.get
import com.example.storeapp.Components.BaseActivity
import com.example.storeapp.Components.getWidthScreen
import com.example.storeapp.R
import com.example.storeapp.databinding.ActivityNoInternetBinding
import com.example.storeapp.databinding.ActivitySplashBinding

class NoInternetActivity : BaseActivity() {
    lateinit var binding: ActivityNoInternetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoInternetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //this activity is all time portrait
        defineDialog()
        // set action click for buttons
        binding.btnMobile.setOnClickListener{goToMobileData()}
        binding.btnWifi.setOnClickListener{goToWifi()}

    }

    //portrait orientation method
    fun defineDialog(){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O){
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        //distance from all screen mobile
        val mWidth:ViewGroup.LayoutParams = binding.clRootNoInternet.layoutParams
        mWidth.width = getWidthScreen(this)-100
        binding.clRootNoInternet.layoutParams
    }

    //go to wifi setting in mobile
    fun goToWifi(){
        val intent = Intent(Intent.ACTION_MAIN ,null)
        intent.addCategory(Intent.CATEGORY_LAUNCHER)
        val cn = ComponentName("com.android.settings" , "com.android.settings.wifi.WifiSettings")
        intent.component = cn
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    // go to mobile data setting in mobile
    fun goToMobileData(){
        val intent = Intent()
        intent.component = ComponentName(
            "com.android.settings",
            "com.android.settings.Settings\$DataUsageSummaryActivity"
        )
        startActivity(intent)
    }
}