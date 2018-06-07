package com.example.futux.data

abstract class UserRepository {
    abstract fun getUser(username: String): User
}

class TestUserRepository : UserRepository() {
    override fun getUser(username: String): User {
        return User("kashifmin", "Kashif Minhaj", 97)
    }
}