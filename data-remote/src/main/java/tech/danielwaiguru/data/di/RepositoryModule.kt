package tech.danielwaiguru.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.danielwaiguru.data.repository.MovieRepositoryImpl
import tech.danielwaiguru.domain.repository.MovieRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun provideMovieRepository(movieRepoImpl: MovieRepositoryImpl): MovieRepository
}