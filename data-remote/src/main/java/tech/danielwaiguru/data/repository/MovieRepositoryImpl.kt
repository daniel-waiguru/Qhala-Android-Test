package tech.danielwaiguru.data.repository

import kotlinx.coroutines.flow.Flow
import tech.danielwaiguru.data.api.MovieApiService
import tech.danielwaiguru.domain.models.Movie
import tech.danielwaiguru.domain.repository.MovieRepository

class MovieRepositoryImpl(private val apiService: MovieApiService): MovieRepository {
    override suspend fun getPopularMovies(): Flow<List<Movie>> {
        TODO("Not yet implemented")
    }
}