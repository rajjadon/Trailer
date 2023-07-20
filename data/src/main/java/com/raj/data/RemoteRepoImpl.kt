package com.raj.data

import com.raj.datasource.remote.networkService.NetworkService
import com.raj.domain.repo.RemoteRepo
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(private val networkService: NetworkService): RemoteRepo {
    override suspend fun getMovieList() {
        TODO("Not yet implemented")
    }
}