package com.example.futux.data

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface RestService {
    @GET("/users/{username}")
    fun getUser(@Path("username") username: String) : Observable<User>
}

fun createRetrofitInstance() = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

fun createRestService() : RestService {
    val retrofit = createRetrofitInstance()
    return retrofit.create(RestService::class.java)
}