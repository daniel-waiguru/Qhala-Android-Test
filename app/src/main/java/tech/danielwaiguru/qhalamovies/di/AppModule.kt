package tech.danielwaiguru.qhalamovies.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.danielwaiguru.domain.repository.MovieRepository
import tech.danielwaiguru.domain.use_cases.GetPopularMovieUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideGetMoviesUseCase(movieRepo: MovieRepository): GetPopularMovieUseCase {
        return GetPopularMovieUseCase(movieRepo)
    }
}