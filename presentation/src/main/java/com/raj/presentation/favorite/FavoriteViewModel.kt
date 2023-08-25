package com.raj.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raj.common.baseClasses.DataState
import com.raj.common.extension.invokeOnIO
import com.raj.common.extension.toSharedFlow
import com.raj.domain.model.TrendingDomain
import com.raj.domain.useCase.GetFavoriteMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavoriteMovieListUseCase: GetFavoriteMovieListUseCase
) :
    ViewModel() {

    private val _movieList = MutableSharedFlow<DataState<List<TrendingDomain>>>()
    val movieList = _movieList.toSharedFlow()

    fun getMovieList() {
        getFavoriteMovieListUseCase.invokeOnIO(
            params = Unit,
            scope = viewModelScope,
            onResult = {
                _movieList.emit(it)
            }
        )
    }
}