package tech.danielwaiguru.data_local.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import tech.danielwaiguru.data_local.dao.MovieDao
import tech.danielwaiguru.data_local.database.MovieDatabase
import tech.danielwaiguru.data_local.utils.Constants.DB_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Singleton
    @Provides
    fun provideMovieDatabase(@ApplicationContext context: Context): MovieDatabase =
        Room.databaseBuilder(context, MovieDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideMovieDao(database: MovieDatabase): MovieDao = database.getMovieDao()
}