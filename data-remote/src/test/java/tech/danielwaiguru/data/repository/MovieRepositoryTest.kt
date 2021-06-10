package tech.danielwaiguru.data.repository

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering
import org.robolectric.RobolectricTestRunner
import tech.danielwaiguru.data.BaseTest
import tech.danielwaiguru.data_local.database.MovieDatabase
import tech.danielwaiguru.domain.repository.MovieRepository

/*
@RunWith(RobolectricTestRunner::class)
class MovieRepositoryTest: BaseTest() {
    private lateinit var movieRepository: MovieRepository
    override fun setup() {
        super.setup()
        val context = ApplicationProvider.getApplicationContext<Context>()
        val movieDb = Room.inMemoryDatabaseBuilder(context, MovieDatabase::class.java).build()
        movieRepository = MovieRepositoryImpl(apiService, movieDb.getMovieDao())
    }
    @Test
    fun `test fetching popular movies returns movie list`() = runBlocking {
        val movies = movieRepository.getPopularMovies()
        movies.collect {
            Truth.assertThat(it.size).isAtLeast(1)
        }
    }
}*/
