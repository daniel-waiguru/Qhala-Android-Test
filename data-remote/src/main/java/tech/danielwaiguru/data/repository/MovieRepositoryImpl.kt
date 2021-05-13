package tech.danielwaiguru.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import tech.danielwaiguru.data.api.MovieApiService
import tech.danielwaiguru.data.mappers.toDomain
import tech.danielwaiguru.data_local.dao.MovieDao
import tech.danielwaiguru.data_local.mappers.toDomain
import tech.danielwaiguru.data_local.mappers.toEntity
import tech.danielwaiguru.domain.models.Movie
import tech.danielwaiguru.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
        private val apiService: MovieApiService, private val movieDao: MovieDao): MovieRepository {
    override suspend fun getPopularMovies(): Flow<List<Movie>> {
        return flow {
            val response = apiService.getPopularMovies().results.map { movieDto ->
                movieDto.toDomain()
            }
            emit(response)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getMovieDetails(mId: Int): Flow<Movie> {
        return flow {
            emit(apiService.getMovieDetails(mId = mId).toDomain())
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun fetCachedData(): Flow<List<Movie>> {
        return flow {
            emit(movieDao.getAllMovies().map { it.toDomain() })
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun storeMovies(movies: List<Movie>) {
        val entities = movies.map { it.toEntity() }
        movieDao.storeMovies(entities)
    }
}