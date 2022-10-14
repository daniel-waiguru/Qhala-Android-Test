package tech.danielwaiguru.data_local.dao

import androidx.paging.PagingSource
import androidx.room.*
import tech.danielwaiguru.data_local.models.MovieEntity

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun storeMovies(movies: List<MovieEntity>)

    @Query("SELECT * FROM movies")
    suspend fun getAllMovies(): List<MovieEntity>

    @Query("SELECT * FROM movies")
    fun getMovies(): PagingSource<Int, MovieEntity>

    /**
     * Get single movie details
     */
    @Query("SELECT * FROM movies WHERE id =:mId")
    fun getMovie(mId: Int): MovieEntity

    @Transaction
    suspend fun upsertMovies(onUpsert: suspend () -> Unit) {
        onUpsert()
    }

    @Query("DELETE FROM movies")
    suspend fun deleteAllMovies()
}