package com.example.futux.di

import com.example.futux.data.ProdUserRepository
import dagger.Component

@DefaultScope
@Component(dependencies = [ NetComponent::class ], modules = [ RestModule::class ])
interface RestComponent {
    fun inject(repository: ProdUserRepository)
}