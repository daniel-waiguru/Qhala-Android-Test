package tech.danielwaiguru.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import tech.danielwaiguru.domain.models.Movie

interface MoviesRepository {
    suspend fun getPopularMovies(): Flow<List<Movie>>
    suspend fun getMovieDetails(mId: Int): Flow<Movie>
    suspend fun fetCachedData(): Flow<List<Movie>>
    suspend fun storeMovies(movies: List<Movie>)

    fun getMovies(): Flow<PagingData<Movie>>
}