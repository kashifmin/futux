package com.example.futux.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.futux.di.DaggerNetComponent
import com.example.futux.di.DaggerRestComponent
import com.example.futux.di.NetModule
import com.example.futux.di.RestModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

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

class ProdUserRepository() : UserRepository() {

    init {
        val netComponent = DaggerNetComponent.builder().netModule(NetModule("https://api.github.com"))
                .build()
        val restComponent = DaggerRestComponent.builder().netComponent(netComponent).restModule(RestModule()).build()
        restComponent.inject(this)
    }

    @Inject lateinit var webService: RestService
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