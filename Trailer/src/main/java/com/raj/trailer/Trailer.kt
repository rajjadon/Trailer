package com.raj.trailer

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class Trailer : Application() {
    override fun onCreate() {
        super.onCreate()

        /*if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())*/
    }
}