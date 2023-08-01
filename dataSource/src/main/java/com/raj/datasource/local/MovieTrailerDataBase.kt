package com.raj.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raj.datasource.model.RoomDbTrendingDomain

@Database(entities = [RoomDbTrendingDomain::class], version = 1, exportSchema = false)
abstract class MovieTrailerDataBase : RoomDatabase() {
    abstract val moviesTrailerDao: MoviesTrailerDao
}