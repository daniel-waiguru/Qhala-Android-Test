package tech.danielwaiguru.qhalamovies.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.danielwaiguru.domain.repository.MovieRepository
import tech.danielwaiguru.domain.use_cases.FetchLocalDataUseCase
import tech.danielwaiguru.domain.use_cases.GetMovieDetailsUseCase
import tech.danielwaiguru.domain.use_cases.GetPopularMovieUseCase
import tech.danielwaiguru.domain.use_cases.StoreMovieUseCase
import tech.danielwaiguru.qhalamovies.ui.viewmodels.MovieDetailViewModelFactory
import tech.danielwaiguru.qhalamovies.ui.viewmodels.MovieViewModelFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideGetMoviesUseCase(movieRepo: MovieRepository): GetPopularMovieUseCase {
        return GetPopularMovieUseCase(movieRepo)
    }
    @Singleton
    @Provides
    fun provideGetMovieDetailUseCase(movieRepo: MovieRepository): GetMovieDetailsUseCase {
        return GetMovieDetailsUseCase(movieRepo)
    }
    @Singleton
    @Provides
    fun provideLocalDataUseCase(movieRepo: MovieRepository): FetchLocalDataUseCase {
        return FetchLocalDataUseCase(movieRepo)
    }
    @Singleton
    @Provides
    fun provideStoreMovieUseCase(movieRepo: MovieRepository): StoreMovieUseCase {
        return StoreMovieUseCase(movieRepo)
    }
    @Singleton
    @Provides
    fun provideViewModelFactory(
            popularMovieUseCase: GetPopularMovieUseCase,
            storeUseCase: StoreMovieUseCase,
            localDataUseCase: FetchLocalDataUseCase): MovieViewModelFactory {
        return MovieViewModelFactory(popularMovieUseCase, storeUseCase, localDataUseCase)
    }
    @Singleton
    @Provides
    fun provideDetailViewModelFactory(
        detailsUseCase: GetMovieDetailsUseCase): MovieDetailViewModelFactory {
        return MovieDetailViewModelFactory(detailsUseCase)
    }
}