package com.raj.trailer

import android.app.Application
import timber.log.Timber

class Trailer : Application() {
    override fun onCreate() {
        super.onCreate()

//        if (BuildConfig.DEBUG)
//            Timber.plant(Timber.DebugTree())
    }
}