package com.raj.datasource.remote.networkService

import com.raj.datasource.BuildConfig
import com.raj.datasource.model.TrendingApiResponse
import retrofit2.http.GET

interface NetworkService {

    @GET(BuildConfig.TRENDING)
    suspend fun getTrending(): TrendingApiResponse
}
