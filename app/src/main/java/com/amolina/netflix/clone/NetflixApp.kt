package com.amolina.netflix.clone

import android.app.Application
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
@HiltAndroidApp
class NetflixApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}