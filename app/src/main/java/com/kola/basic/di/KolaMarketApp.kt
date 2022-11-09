package com.kola.basic.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KolaMarketApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}