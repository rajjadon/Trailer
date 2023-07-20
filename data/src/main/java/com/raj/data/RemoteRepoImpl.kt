package com.raj.data

import com.raj.domain.repo.RemoteRepo
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(): RemoteRepo {
    override suspend fun getMovieList() {
        TODO("Not yet implemented")
    }
}