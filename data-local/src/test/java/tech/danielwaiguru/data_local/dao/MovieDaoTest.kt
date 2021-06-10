package tech.danielwaiguru.data_local.dao

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.github.testcoroutinesrule.TestCoroutineRule
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import tech.danielwaiguru.data_local.database.MovieDatabase
import tech.danielwaiguru.data_local.dummyMovies

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
class MovieDaoTest {
    private lateinit var movieDb: MovieDatabase
    private lateinit var movieDao: MovieDao
    @ExperimentalCoroutinesApi
    @get: Rule
    val rule = InstantTaskExecutorRule()
    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        movieDb = Room.inMemoryDatabaseBuilder(context, MovieDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        movieDao = movieDb.getMovieDao()
    }

    @Test
    fun `test storing movies`() = runBlockingTest {
        movieDao.storeMovies(dummyMovies)
        val allMovies = movieDao.getAllMovies()
        Truth.assertThat(allMovies).isEqualTo(dummyMovies)
    }
    @After
    fun teardown() {
        movieDb.clearAllTables()
        movieDb.close()
    }
}