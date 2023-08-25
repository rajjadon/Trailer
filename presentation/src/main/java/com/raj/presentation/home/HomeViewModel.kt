package com.raj.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raj.common.baseClasses.DataState
import com.raj.common.extension.invokeOnIO
import com.raj.common.extension.toSharedFlow
import com.raj.domain.model.TrendingDomain
import com.raj.domain.useCase.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    private val _movieList = MutableSharedFlow<DataState<List<TrendingDomain>>>()
    val movieList = _movieList.toSharedFlow()

    fun getMovieList() {
        getMovieListUseCase.invokeOnIO(params = Unit, scope = viewModelScope, onResult = {
            _movieList.emit(it)
        })
    }
}