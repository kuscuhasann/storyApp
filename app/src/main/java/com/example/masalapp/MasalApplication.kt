package com.example.masalapp

import android.app.Application
import com.example.masalapp.di.AppContainer
import com.example.masalapp.di.DefaultAppContainer

class MasalApplication : Application() {
    lateinit var container: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
