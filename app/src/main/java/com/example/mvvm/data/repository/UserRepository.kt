package com.example.mvvm.data.repository

import androidx.lifecycle.LiveData
import com.example.mvvm.App
import com.example.mvvm.data.models.UserModel

class UserRepository {
    fun signUp(user: UserModel) {
        App.preferenceHelper.username = user.username
        App.preferenceHelper.age = user.age
        App.preferenceHelper.password = user.password
        App.preferenceHelper.email = user.email
    }

    fun getUserInfo(): UserModel {
        App.preferenceHelper.apply {
            return UserModel(
                username = username,
                age = age,
                email = email,
                password = password
            )
        }
    }
    fun updateUserInfo(userModel: UserModel){
        App.preferenceHelper.apply {
            username = userModel.username
            age= userModel.age
            password = userModel.password
            email = userModel.email
        }
    }
}
