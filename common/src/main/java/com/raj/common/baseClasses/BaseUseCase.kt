package com.raj.common.baseClasses

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

abstract class BaseUseCase<in Params, out ApiResponse> where ApiResponse : Any {

    abstract suspend fun run(
        params: Params,
        scope: CoroutineScope,
    ): Flow<DataState<ApiResponse>>

    inline operator fun <Params, ApiResponse : Any> BaseUseCase<Params, ApiResponse>.invoke(
        dispatcher: CoroutineDispatcher,
        params: Params,
        scope: CoroutineScope,
        crossinline onResult: suspend (DataState<ApiResponse>) -> Unit,
    ) {
        scope.launch(dispatcher) {
            run(params, scope).onEach {
                onResult.invoke(it)
            }.launchIn(this)
        }
    }
}