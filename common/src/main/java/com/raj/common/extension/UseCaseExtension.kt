package com.raj.common.extension

import com.raj.common.baseClasses.BaseUseCase
import com.raj.common.baseClasses.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

inline fun <Params, ApiResponse : Any> BaseUseCase<Params, ApiResponse>.invokeOnIO(
    params: Params,
    viewModel: BaseViewModel,
    crossinline onResult: (Flow<Any>) -> Unit = {},
    crossinline onCancelled: (Exception) -> Unit = {}
): CoroutineScope = run {
    val job = CoroutineScope(Dispatchers.IO)
    invoke(
        scope = job,
        params = params,
        baseViewModel = viewModel,
        onResult = onResult,
        onCancelled = onCancelled
    )
    job
}

inline fun <Params, ApiResponse : Any> BaseUseCase<Params, ApiResponse>.invokeOnDefault(
    params: Params,
    baseViewModel: BaseViewModel,
    crossinline onResult: (Flow<Any>) -> Unit = {},
    crossinline onCancelled: (Exception) -> Unit = {}
): CoroutineScope = run {
    val job = CoroutineScope(Dispatchers.Default)
    invoke(
        scope = job,
        params = params,
        baseViewModel = baseViewModel,
        onResult = onResult,
        onCancelled = onCancelled
    )
    job
}

inline fun <Params, ApiResponse : Any> BaseUseCase<Params, ApiResponse>.invokeAsync(
    context: CoroutineContext = Dispatchers.IO,
    crossinline scope: suspend CoroutineScope.() -> Unit
) {
    val job = CoroutineScope(context)
    job.launch(context) { scope(this) }
}