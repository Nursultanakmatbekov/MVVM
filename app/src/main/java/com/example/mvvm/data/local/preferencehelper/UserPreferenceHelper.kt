package com.example.mvvm.data.local.preferencehelper

import android.content.Context
import android.content.SharedPreferences

object UserPreferenceHelper{

    private lateinit var sharedPreferences: SharedPreferences

    fun unit(context: Context) {
        sharedPreferences = context.getSharedPreferences("singUp", Context.MODE_PRIVATE)
    }

    var isSignUp: Boolean
        get() = sharedPreferences.getBoolean("key", false)
        set(value) = sharedPreferences.edit().putBoolean("key", value).apply()
}