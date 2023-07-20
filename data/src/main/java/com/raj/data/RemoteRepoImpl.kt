package com.raj.data

import com.raj.common.baseClasses.DataState
import com.raj.datasource.remote.networkService.NetworkService
import com.raj.domain.repo.RemoteRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(private val networkService: NetworkService): RemoteRepo {
    override suspend fun getMovieList() : Flow<DataState<Unit>> = flow{
        emit(DataState.Loading)
        emit(DataState.Success(Unit))
    }
}