package com.raj.domain.useCase

import com.raj.common.baseClasses.BaseUseCase
import com.raj.common.baseClasses.DataState
import com.raj.common.error.HttpRequestError
import com.raj.domain.model.TrendingDomain
import com.raj.domain.repo.LocalRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddMovieInFavoriteUseCase @Inject constructor(private val localRepo: LocalRepo) :
    BaseUseCase<TrendingDomain, Unit>() {
    override suspend fun run(
        params: TrendingDomain,
        scope: CoroutineScope
    ): Flow<DataState<Unit>> = flow {
        try {
            emit(DataState.Success(localRepo.insert(params)))
        } catch (e: Exception) {
            emit(
                DataState.Error(
                    HttpRequestError.SomeThingWentWrong(
                        code = 0,
                        errorMessage = e.message.toString()
                    )
                )
            )
        }
    }
}