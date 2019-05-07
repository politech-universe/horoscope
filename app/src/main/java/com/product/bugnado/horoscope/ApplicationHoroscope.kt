package com.product.bugnado.horoscope

import android.app.Application
import android.content.res.Configuration
import com.vk.sdk.VKSdk

class ApplicationHoroscope : Application() {

    override fun onCreate() {
        super.onCreate()
        VKSdk.initialize(this.applicationContext)

    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }
}