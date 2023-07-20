package com.raj.presentation.home

import androidx.lifecycle.viewModelScope
import com.raj.common.baseClasses.BaseViewModel
import com.raj.common.extension.invokeOnViewModelScope
import com.raj.domain.useCase.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getMovieListUseCase: GetMovieListUseCase) : BaseViewModel(){

    fun getMovieList(){
        getMovieListUseCase.invokeOnViewModelScope(
            params = Unit,
            scope = viewModelScope,
            onResult = {
                it.onEach {

                }.launchIn(viewModelScope)
            }
        )
    }

    override fun cancelApiJob() {
        TODO("Not yet implemented")
    }
}