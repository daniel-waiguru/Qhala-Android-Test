package tech.danielwaiguru.data_local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import tech.danielwaiguru.domain.models.Movie

interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun storeMovies(movies: List<Movie>)

    @Query("SELECT * FROM movies")
    suspend fun getAllMovies(): Flow<List<Movie>>

    /**
     * Get single movie details
     */
    @Query("SELECT * FROM movies WHERE id =:mId")
    suspend fun getMovie(mId: Int): Flow<Movie>
}