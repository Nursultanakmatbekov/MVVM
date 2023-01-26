package com.example.mvvm.ui.fragments.userinfofragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.data.models.UserModel
import com.example.mvvm.data.repository.UserRepository

class UserInfoViewModel : ViewModel() {

    private val _userLiveData = MutableLiveData<UserModel>()
    val userLiveData: LiveData<UserModel> = _userLiveData
    private val repository = UserRepository()

    fun getUserInfo() {
        _userLiveData.value = repository.getUserInfo()
    }
}