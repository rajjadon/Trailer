package com.raj.data

import com.raj.common.baseClasses.DataState
import com.raj.common.qualifiers.ApiConstantEnum
import com.raj.common.qualifiers.ApiQualifier
import com.raj.data.extension.toTrendingDomain
import com.raj.datasource.remote.SafeApiRequest
import com.raj.datasource.remote.networkService.NetworkService
import com.raj.domain.model.TrendingDomain
import com.raj.domain.repo.RemoteRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(
    private val networkService: NetworkService,
    private val safeApiRequest: SafeApiRequest,
    @ApiQualifier(ApiConstantEnum.IMAGE_LOADING_URL) private val imageLoadingUrl: String
) : RemoteRepo {
    override suspend fun getMovieList(): Flow<DataState<List<TrendingDomain>>> = flow {
        emit(safeApiRequest.apiRequest {
            networkService.getTrending().results.map {
                it.toTrendingDomain(imageLoadingUrl)
            }
        })
    }
}