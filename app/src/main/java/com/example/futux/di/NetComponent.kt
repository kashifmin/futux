package com.example.futux.di

import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [ NetModule::class ])
interface NetComponent {
    fun retrofit() : Retrofit
}