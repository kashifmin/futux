package com.example.futux.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.futux.data.ProdUserRepository
import com.example.futux.data.User
import com.example.futux.data.UserRepository

class MainViewModel : ViewModel() {
    var user: LiveData<User>? = null
    private set
    val userRepository: UserRepository = ProdUserRepository()

    fun init(username: String) {
        user = userRepository.getUser(username)
    }

}
