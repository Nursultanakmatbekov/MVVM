package com.example.mvvm.ui.fragments.editfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.App
import com.example.mvvm.data.models.UserModel
import com.example.mvvm.data.repository.UserRepository

class EditViewModel : ViewModel() {

    private val _userLiveData = MutableLiveData<UserModel>()
    val userLiveData: LiveData<UserModel> = _userLiveData
    private val repository = UserRepository()

    fun getInfo(): LiveData<UserModel> {
        App.preferenceHelper.apply {
            _userLiveData.value = UserModel(
                username = username,
                age = age,
                password = password,
                email = email
            )
        }
        return userLiveData
    }

    fun updateUserInfo(username: String, age: Int, email: String, password: String) {
        repository.updateUserInfo(UserModel(username, age, email, password))
    }
}