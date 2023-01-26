package com.example.mvvm.ui.fragments.sinupfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.App
import com.example.mvvm.data.models.UserModel
import com.example.mvvm.data.repository.UserRepository

class SingUpViewModel : ViewModel() {

    private val  repository = UserRepository()

    fun signUp(username : String, age : Int, email : String, password: String ){
        repository.signUp(UserModel(username,age,email,password))
    }
}