package tech.danielwaiguru.data_local.base

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import org.junit.After
import org.junit.Before
import tech.danielwaiguru.data_local.dao.MovieDao
import tech.danielwaiguru.data_local.database.MovieDatabase

internal open class BaseTest {
    private lateinit var movieDb: MovieDatabase
    protected open lateinit var movieDao: MovieDao
    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        movieDb = Room.inMemoryDatabaseBuilder(context, MovieDatabase::class.java).build()
        movieDao = movieDb.getMovieDao()
    }
    @After
    fun teardown() {
        movieDb.clearAllTables()
        movieDb.close()
    }
}