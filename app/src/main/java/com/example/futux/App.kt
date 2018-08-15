package com.example.futux

import android.app.Application
import com.example.futux.di.*

class App : Application() {
    var restComponent: RestComponent? = null

    override fun onCreate() {
        super.onCreate()
        val netComponent = DaggerNetComponent.builder().netModule(NetModule("https://api.github.com"))
                .build()
        restComponent = DaggerRestComponent.builder().netComponent(netComponent).restModule(RestModule()).build()
    }


}