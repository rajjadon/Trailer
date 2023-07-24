package com.raj.trailer.di

import com.raj.common.qualifiers.ApiConstantEnum
import com.raj.common.qualifiers.ApiQualifier
import com.raj.trailer.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object provideAppUrl {

    @Provides
    @ApiQualifier(ApiConstantEnum.BASE_URL)
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @ApiQualifier(ApiConstantEnum.ACCESS_TOKEN)
    fun provideAccessToken() = "Bearer ${BuildConfig.ACCESS_TOKEN}"

    @Provides
    @ApiQualifier(ApiConstantEnum.API_KEY)
    fun provideApiKey() = BuildConfig.API_KEY
}