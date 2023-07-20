package com.raj.common.extension

import com.raj.common.baseClasses.BaseUseCase
import com.raj.common.baseClasses.BaseViewModel
import com.raj.common.baseClasses.DataState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

inline fun <Params, ApiResponse : Any> BaseUseCase<Params, ApiResponse>.invokeOnViewModelScope(
    params: Params,
    scope: CoroutineScope,
    crossinline onResult: (Flow<DataState<ApiResponse>>) -> Unit = {}
) = run {
    invoke(
        params = params,
        scope = scope,
        onResult = onResult,
    )
}