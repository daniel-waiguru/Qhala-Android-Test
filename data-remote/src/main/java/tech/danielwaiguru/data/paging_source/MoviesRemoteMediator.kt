package tech.danielwaiguru.data.paging_source

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import retrofit2.HttpException
import tech.danielwaiguru.data.api.MovieApiService
import tech.danielwaiguru.data.mappers.toEntity
import tech.danielwaiguru.data.models.MovieDto
import tech.danielwaiguru.data_local.dao.MovieDao
import tech.danielwaiguru.data_local.dao.RemoteKeyDao
import tech.danielwaiguru.data_local.models.MovieEntity
import tech.danielwaiguru.data_local.models.RemoteKey
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class MoviesRemoteMediator(
    private val apiService: MovieApiService,
    private val movieDao: MovieDao,
    private val remoteKeyDao: RemoteKeyDao
): RemoteMediator<Int, MovieEntity>() {
    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, MovieEntity>
    ): MediatorResult {
        val loadKey = when(loadType) {
            LoadType.REFRESH -> {
                val remoteKey = getRemoteKeyClosestToCurrentPosition(state)
                remoteKey?.nextPage?.minus(1) ?: START_INDEX
            }
            LoadType.PREPEND -> {
                val remoteKey = getRemoteKeyForFirstItem(state)
                val prevPage = remoteKey?.prevPage ?: return MediatorResult.Success(
                    endOfPaginationReached = remoteKey != null
                )
                prevPage
            }
            LoadType.APPEND -> {
                //val remoteKey = getRemoteKeyForLastItem(state)
                val remoteKey = remoteKeyDao.getLastRemoteKey()
                val nextPage = remoteKey?.nextPage ?: return MediatorResult.Success(
                    endOfPaginationReached = remoteKey != null
                )
                Log.i("PAGING", "PAGE REMOTE $remoteKey")
                nextPage
            }
        }
        return  try {
            val response = apiService.getPopularMovies(
                page = loadKey
            )
            val endOfPaginationReached = response.results.isEmpty()
            movieDao.upsertMovies {
                if (loadType == LoadType.REFRESH) {
                    movieDao.deleteAllMovies()
                    remoteKeyDao.deleteAllKeys()
                }
                val prevPage = if (loadKey == START_INDEX) null else loadKey.minus(1)
                val nextPage = if (endOfPaginationReached) null else loadKey.plus(1)
                Log.i("PAGING", "next $nextPage")
                val remoteKeys = response.results.map { movieDto ->
                    RemoteKey(
                        movieId = movieDto.id,
                        prevPage = prevPage,
                        nextPage = nextPage
                    )
                }
                val movieEntities = response.results.map(MovieDto::toEntity)
                remoteKeyDao.saveKeys(remoteKeys)
                movieDao.storeMovies(movieEntities)
            }
            MediatorResult.Success(
                endOfPaginationReached = endOfPaginationReached
            )
        } catch (exception: HttpException) {
            MediatorResult.Error(exception)
        } catch (exception: IOException) {
            MediatorResult.Error(exception)
        }
    }
    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, MovieEntity>
    ): RemoteKey? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                remoteKeyDao.getRemoteKeyById(keyId = id)
            }
        }
    }
    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, MovieEntity>
    ): RemoteKey? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { movie ->
                remoteKeyDao.getRemoteKeyById(keyId = movie.id)
            }
    }
    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, MovieEntity>
    ): RemoteKey? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { movie ->
                remoteKeyDao.getRemoteKeyById(keyId = movie.id)
            }

    }
    companion object {
        const val START_INDEX = 1
    }
}