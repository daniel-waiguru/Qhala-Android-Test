package tech.danielwaiguru.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import tech.danielwaiguru.domain.repository.MovieRepository
import tech.danielwaiguru.domain.use_cases.FetchLocalDataUseCase
import tech.danielwaiguru.domain.use_cases.GetMovieDetailsUseCase
import tech.danielwaiguru.domain.use_cases.GetPopularMovieUseCase
import tech.danielwaiguru.domain.use_cases.StoreMovieUseCase

@Module
@InstallIn(ViewModelComponent::class)
class UsesCasesModule {
    @ViewModelScoped
    @Provides
    fun provideGetMoviesUseCase(movieRepo: MovieRepository): GetPopularMovieUseCase {
        return GetPopularMovieUseCase(movieRepo)
    }
    @ViewModelScoped
    @Provides
    fun provideGetMovieDetailUseCase(movieRepo: MovieRepository): GetMovieDetailsUseCase {
        return GetMovieDetailsUseCase(movieRepo)
    }
    @ViewModelScoped
    @Provides
    fun provideLocalDataUseCase(movieRepo: MovieRepository): FetchLocalDataUseCase {
        return FetchLocalDataUseCase(movieRepo)
    }
    @ViewModelScoped
    @Provides
    fun provideStoreMovieUseCase(movieRepo: MovieRepository): StoreMovieUseCase {
        return StoreMovieUseCase(movieRepo)
    }
}