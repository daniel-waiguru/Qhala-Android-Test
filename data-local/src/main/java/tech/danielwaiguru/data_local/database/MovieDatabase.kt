package tech.danielwaiguru.data_local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import tech.danielwaiguru.data_local.dao.MovieDao
import tech.danielwaiguru.data_local.models.MovieEntity

@Database(entities = [MovieEntity::class], exportSchema = false, version = 1)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun getMovieDao(): MovieDao
}