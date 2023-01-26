package com.example.mvvm.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mvvm.R
import com.example.mvvm.data.local.preferencehelper.UserPreferenceHelper

class MainActivity : AppCompatActivity() {

    private lateinit var navHost: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment

        navHost = navHostFragment.navController

        when (UserPreferenceHelper.isSignUp) {
            true -> {
                navHost.navigate(R.id.userInfoFragment)
            }
            else -> {
                navHost.navigate(R.id.singUpFragment)
            }
        }
    }
}
