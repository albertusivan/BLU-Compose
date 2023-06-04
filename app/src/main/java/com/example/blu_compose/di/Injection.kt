package com.example.blu_compose.di

import com.example.blu_compose.data.Repository

object Injection {
    fun provideRepository(): Repository {
        return Repository.getInstance()
    }
}