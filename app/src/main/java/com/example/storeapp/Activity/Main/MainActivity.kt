package com.example.storeapp.Activity.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.storeapp.R
import com.example.storeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private  var currentItem:String = "home"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        defaultPage()
        clickItems()

    }

    // bind layouts
    private fun bind() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // onClickListener function for layout icons
    private fun clickItems() {
        binding.buttonNavigation.llUser.setOnClickListener {
            // when click on user icon
            userClicked()
        }

        binding.buttonNavigation.llCategory.setOnClickListener {
            //when click on category icon
            categoryClicked()
        }

        binding.buttonNavigation.llHome.setOnClickListener {
            // when click on home icon
            homeClicked()

        }
        binding.buttonNavigation.llShopping.setOnClickListener {
            // when click shopping icon
            shoppingClicked()
        }
    }

    // always run when user start application(we choose home page)
    private fun defaultPage() {
        homeClicked()
    }

    private fun userClicked() {
        deselectItem(currentItem)
        currentItem = "user"
        binding.buttonNavigation.ivUser.setImageDrawable(getDrawable(R.drawable.ic_user_gold))
        binding.buttonNavigation.tvUser.setTextColor(getColor(R.color.gold))
    }

    private fun shoppingClicked() {
        deselectItem(currentItem)
        currentItem = "shopping"
        binding.buttonNavigation.ivShopping.setImageDrawable(getDrawable(R.drawable.ic_shopping_gold))
        binding.buttonNavigation.tvShopping.setTextColor(getColor(R.color.gold))
    }

    private fun categoryClicked() {
        deselectItem(currentItem)
        currentItem = "category"
        binding.buttonNavigation.ivCategory.setImageDrawable(getDrawable(R.drawable.ic_category_gold))
        binding.buttonNavigation.tvCategory.setTextColor(getColor(R.color.gold))

    }

    private fun homeClicked() {
        deselectItem(currentItem)
        currentItem = "home"
        binding.buttonNavigation.ivHome.setImageDrawable(getDrawable(R.drawable.ic_home_gold))
        binding.buttonNavigation.tvHome.setTextColor(getColor(R.color.gold))

    }

    private fun deselectItem(item:String){
        when(item){
            "home" -> {
                binding.buttonNavigation.ivHome.setImageDrawable(getDrawable(R.drawable.ic_home_white))
                binding.buttonNavigation.tvHome.setTextColor(getColor(R.color.white))
            }
            "category" ->{
                binding.buttonNavigation.ivCategory.setImageDrawable(getDrawable(R.drawable.ic_category_white))
                binding.buttonNavigation.tvCategory.setTextColor(getColor(R.color.white))
            }
            "shopping" -> {
                binding.buttonNavigation.ivShopping.setImageDrawable(getDrawable(R.drawable.ic_shopping_white))
                binding.buttonNavigation.tvShopping.setTextColor(getColor(R.color.white))

            }
            "user" -> {
                binding.buttonNavigation.ivUser.setImageDrawable(getDrawable(R.drawable.ic_user_white))
                binding.buttonNavigation.tvUser.setTextColor(getColor(R.color.white))
            }
        }
    }

}