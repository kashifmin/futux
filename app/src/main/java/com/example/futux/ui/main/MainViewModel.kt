package com.example.futux.ui.main

import androidx.lifecycle.ViewModel
import com.example.futux.data.TestUserRepository
import com.example.futux.data.User
import com.example.futux.data.UserRepository

class MainViewModel : ViewModel() {
    var user: User? = null
    private set
    val userRepository: UserRepository = TestUserRepository()

    fun init(username: String) {
        if(user != null) user = userRepository.getUser(username)
    }

}
