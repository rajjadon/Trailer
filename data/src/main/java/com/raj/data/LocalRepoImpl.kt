package com.raj.data

import com.raj.common.qualifiers.ApiConstantEnum
import com.raj.common.qualifiers.ApiQualifier
import com.raj.data.extension.toRoomDbTrendingDomain
import com.raj.data.extension.toTrendingDomain
import com.raj.datasource.local.MoviesTrailerDao
import com.raj.domain.model.TrendingDomain
import com.raj.domain.repo.LocalRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalRepoImpl @Inject constructor(
    private val moviesTrailerDao: MoviesTrailerDao,
    @ApiQualifier(ApiConstantEnum.IMAGE_LOADING_URL) private val imageLoadingUrl: String
) :
    LocalRepo {
    override suspend fun insert(trendingDomain: TrendingDomain) =
        moviesTrailerDao.insert(trendingDomain.toRoomDbTrendingDomain(imageLoadingUrl = imageLoadingUrl))

    override suspend fun deleteAll() {
        moviesTrailerDao.deleteAll()
    }

    override suspend fun delete(movieId: String) {
        moviesTrailerDao.delete(movieId)
    }

    override fun getAllMovie(): Flow<List<TrendingDomain>> = flow {
        moviesTrailerDao.getAllMovie().collectLatest {
            emit(
                it.map { localMovie ->
                    localMovie.toTrendingDomain(imageLoadingUrl)
                }
            )
        }
    }

    override suspend fun update(trendingDomain: TrendingDomain) {
        moviesTrailerDao.update(trendingDomain.toRoomDbTrendingDomain(imageLoadingUrl))
    }
}