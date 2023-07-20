package com.raj.common.baseClasses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raj.common.extension.toSharedFlow
import com.raj.common.error.NetworkError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor() : ViewModel() {

    private var _networkError= MutableSharedFlow<NetworkError>()
    val networkError = _networkError.toSharedFlow()

    private var _loading = MutableSharedFlow<Boolean>()
    val loading = _loading.toSharedFlow()

    fun sendError(error: Flow<NetworkError>) {
        viewModelScope.launch {
            error.onEach {
                _networkError.emit(it)
            }.launchIn(this)
        }
    }

    fun callLoading(loading: Flow<Boolean>) {
        viewModelScope.launch {
            loading.onEach {
                _loading.emit(it)
            }.launchIn(this)
        }
    }

    open fun cancelApiJob() {}
}