package com.raj.datasource.remote.di

import com.raj.datasource.remote.networkService.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceProvider {

    @Provides
    @Singleton
    fun provideRemoteDataSource(retrofit: Retrofit.Builder): NetworkService =
        retrofit.build().create(NetworkService::class.java)
}