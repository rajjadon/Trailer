package com.raj.datasource.di

import android.content.Context
import androidx.room.Room
import com.raj.datasource.local.MovieTrailerDataBase
import com.raj.datasource.local.MoviesTrailerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): MoviesTrailerDao {
        return Room.databaseBuilder(
            context,
            MovieTrailerDataBase::class.java,
            "ALARM_DATABASE.db"
        ).fallbackToDestructiveMigration().build().moviesTrailerDao
    }
}