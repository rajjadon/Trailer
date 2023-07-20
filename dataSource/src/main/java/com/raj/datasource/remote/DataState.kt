package com.raj.datasource.remote

import com.raj.datasource.remote.error.NetworkError

sealed class DataState<out T> {
    data class Success<out T>(val baseResponseData: T) : DataState<T>()
    data class Error(val exception: NetworkError) :
        DataState<Nothing>()

    object Loading : DataState<Nothing>()
}