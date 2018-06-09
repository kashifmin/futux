package com.example.futux.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

abstract class UserRepository {
    abstract fun getUser(username: String): LiveData<User>
}

class TestUserRepository : UserRepository() {
    override fun getUser(username: String): LiveData<User> {
        val user = MutableLiveData<User>()

        user.value = User("kashifmin", "Kashif Minhaj", 97)
        return user
    }
}

class ProdUserRepository : UserRepository() {
    val webService: RestService = createRestService()

    override fun getUser(username: String): LiveData<User> {
        val data = MutableLiveData<User>()
        // TODO: cleanup subscription
        webService.getUser(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { data.value = it }


        return data
    }
}