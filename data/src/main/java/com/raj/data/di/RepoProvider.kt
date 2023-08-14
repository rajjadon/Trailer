package com.raj.data.di

import com.raj.data.LocalRepoImpl
import com.raj.data.RemoteRepoImpl
import com.raj.domain.repo.LocalRepo
import com.raj.domain.repo.RemoteRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoProvider {

    @Binds
    abstract fun repoProvider(repoImpl: RemoteRepoImpl): RemoteRepo

    @Binds
    abstract fun localRepoProvider(localRepoImpl: LocalRepoImpl): LocalRepo
}