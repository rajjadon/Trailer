package com.raj.domain.repo

interface RemoteRepo {
    suspend fun getMovieList()
}