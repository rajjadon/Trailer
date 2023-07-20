package com.raj.common.extension

import com.raj.common.baseClasses.BaseUseCase
import com.raj.common.baseClasses.DataState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

inline fun <Params, ApiResponse : Any> BaseUseCase<Params, ApiResponse>.invokeOnIO(
    params: Params,
    scope: CoroutineScope,
    crossinline onResult: suspend (DataState<ApiResponse>) -> Unit = {}
) = run {
    invoke(
        dispatcher = Dispatchers.IO,
        params = params,
        scope = scope,
        onResult = onResult,
    )
}