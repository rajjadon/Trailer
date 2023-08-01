package com.raj.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.raj.datasource.model.RoomDbTrendingDomain
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesTrailerDao {
    @Insert(onConflict = IGNORE)
    suspend fun insert(trendingDomain: RoomDbTrendingDomain)

    @Query("DELETE FROM TRENDING_DOMAIN_TABLE")
    suspend fun deleteAll()

    @Query("DELETE FROM TRENDING_DOMAIN_TABLE WHERE movie_id = :movieId")
    suspend fun delete(movieId: String)

    @Query("SELECT * FROM TRENDING_DOMAIN_TABLE")
    fun getAllMovie(): Flow<List<RoomDbTrendingDomain>>

    @Update(onConflict = REPLACE)
    suspend fun update(trendingDomain: RoomDbTrendingDomain)
}