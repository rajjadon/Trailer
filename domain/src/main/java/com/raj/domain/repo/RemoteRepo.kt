package com.raj.domain.repo

import com.raj.common.baseClasses.DataState
import kotlinx.coroutines.flow.Flow

interface RemoteRepo {
    suspend fun getMovieList() : Flow<DataState<Unit>>
}