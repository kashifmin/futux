package com.example.futux.di

import com.example.futux.data.RestService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RestModule {
    @Provides
    fun providesRestService(retrofit: Retrofit) = retrofit.create(RestService::class.java)
}