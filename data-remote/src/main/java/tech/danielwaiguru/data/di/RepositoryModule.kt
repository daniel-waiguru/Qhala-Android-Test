package tech.danielwaiguru.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.danielwaiguru.data.repository.MoviesRepositoryImpl
import tech.danielwaiguru.domain.repository.MoviesRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun provideMovieRepository(movieRepoImpl: MoviesRepositoryImpl): MoviesRepository
}