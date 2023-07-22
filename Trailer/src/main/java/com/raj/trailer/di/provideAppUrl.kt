package com.raj.trailer.di

import com.raj.trailer.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object provideAppUrl {

    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    fun provideAccessToken() = BuildConfig.ACCESS_TOKEN

    @Provides
    fun provideApiKey() = BuildConfig.API_KEY
}