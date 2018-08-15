package com.example.futux.di

import com.example.futux.ui.main.MainViewModel
import dagger.Component

@Component(modules = [ RepositoryModule::class ])
interface RepositoryComponent {
    fun inject(viewModel: MainViewModel)
}