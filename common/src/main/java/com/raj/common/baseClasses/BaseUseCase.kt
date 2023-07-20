package com.raj.common.baseClasses

import com.raj.common.error.HttpRequestError
import com.raj.common.error.NetworkError
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class BaseUseCase<in Params, out ApiResponse> where ApiResponse : Any {

    abstract suspend fun run(
        params: Params,
        scope: CoroutineScope,
    ): Flow<DataState<ApiResponse>>

    inline operator fun <Params, ApiResponse : Any> BaseUseCase<Params, ApiResponse>.invoke(
        params: Params,
        scope: CoroutineScope,
        crossinline onResult: (Flow<DataState<ApiResponse>>) -> Unit,
    ) {
        scope.launch {
            onResult.invoke(run(params, scope))
        }
    }
}