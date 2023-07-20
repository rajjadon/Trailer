package com.raj.presentation.home

import com.raj.domain.useCase.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(getMovieListUseCase: GetMovieListUseCase){
}