package com.raj.common.baseClasses

import com.raj.common.error.HttpRequestError
import com.raj.common.error.NetworkError
import kotlinx.coroutines.CancellationException
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

    val successChannel = Channel<Any>()
    val loadingChannel = Channel<Boolean>()
    val errorChannel = Channel<NetworkError>()
    abstract suspend fun run(
        params: Params,
        baseViewModel: BaseViewModel
    ): Flow<DataState<ApiResponse>>

    inline operator fun <Params, ApiResponse : Any> BaseUseCase<Params, ApiResponse>.invoke(
        scope: CoroutineScope,
        params: Params,
        baseViewModel: BaseViewModel,
        crossinline onResult: (Flow<Any>) -> Unit = {},
        crossinline onCancelled: (Exception) -> Unit = {}
    ) {
        scope.launch {

            onResult(successChannel.consumeAsFlow())
            baseViewModel.sendError(errorChannel.consumeAsFlow())
            baseViewModel.callLoading(loadingChannel.consumeAsFlow())

            run(params, baseViewModel)
                .onEach {
                    when (it) {
                        is DataState.Error -> {
                            loadingChannel.send(false)
                            errorChannel.send(it.exception)
                        }

                        is DataState.Success<ApiResponse> -> {
                            loadingChannel.send(false)
                            successChannel.send(it.baseResponseData)
                        }

                        is DataState.Loading -> loadingChannel.send(false)
                    }
                }
                .catch { e ->

                    when (e) {
                        is CancellationException -> {
                            onCancelled.invoke(e)
                        }

                        is IllegalStateException -> {
                            Timber.e("Repeated calls")
                        }

                        else -> {
                            errorChannel.send(
                                HttpRequestError.SomeThingWentWrong()
                            )
                        }
                    }
                }.collect()
        }
    }
}