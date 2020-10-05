package com.example.android.dessertclicker

import android.app.Application
import android.content.res.Configuration
import timber.log.Timber

class ClickerApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}