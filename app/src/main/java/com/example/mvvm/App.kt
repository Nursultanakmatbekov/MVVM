package com.example.mvvm

import android.app.Application
import android.content.SharedPreferences
import com.example.mvvm.data.local.preferencehelper.PreferenceHelper
import com.example.mvvm.data.local.preferencehelper.UserPreferenceHelper

class App : Application() {

    companion object{
        lateinit var preferenceHelper: PreferenceHelper
    }

    override fun onCreate() {
        super.onCreate()
        preferenceHelper = PreferenceHelper(applicationContext)
        UserPreferenceHelper.unit(this)
    }
}