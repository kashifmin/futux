package com.example.futux.di

import com.example.futux.data.ProdUserRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun providesRepository() = ProdUserRepository()
}