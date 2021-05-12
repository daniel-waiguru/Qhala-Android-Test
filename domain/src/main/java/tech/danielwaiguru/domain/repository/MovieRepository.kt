package tech.danielwaiguru.domain.repository

import kotlinx.coroutines.flow.Flow
import tech.danielwaiguru.domain.models.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): Flow<List<Movie>>
    suspend fun getMovieDetails(mId: Int): Flow<Movie>
}