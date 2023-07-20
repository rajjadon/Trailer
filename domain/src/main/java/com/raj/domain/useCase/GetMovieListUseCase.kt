package com.raj.domain.useCase

import com.raj.common.baseClasses.BaseUseCase
import com.raj.common.baseClasses.BaseViewModel
import com.raj.common.baseClasses.DataState
import com.raj.domain.repo.RemoteRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(remoteRepo: RemoteRepo) : BaseUseCase<Unit, Unit>() {
    override suspend fun run(params: Unit, baseViewModel: BaseViewModel): Flow<DataState<Unit>> {
        TODO("Not yet implemented")
    }
}