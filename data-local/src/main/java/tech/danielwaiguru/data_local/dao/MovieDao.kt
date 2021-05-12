package tech.danielwaiguru.data_local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import tech.danielwaiguru.data_local.models.MovieEntity
import tech.danielwaiguru.domain.models.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun storeMovies(movies: List<MovieEntity>)

    @Query("SELECT * FROM movies")
    fun getAllMovies(): Flow<List<MovieEntity>>

    /**
     * Get single movie details
     */
    @Query("SELECT * FROM movies WHERE id =:mId")
    fun getMovie(mId: Int): Flow<MovieEntity>
}