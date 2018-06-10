package com.example.futux.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(internal var mApplication: Application) {

    @Provides
    @Singleton
    fun providesApplication() = mApplication
}