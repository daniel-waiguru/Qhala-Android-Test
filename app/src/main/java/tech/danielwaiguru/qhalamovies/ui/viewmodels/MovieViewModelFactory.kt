package tech.danielwaiguru.qhalamovies.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tech.danielwaiguru.domain.use_cases.FetchLocalDataUseCase
import tech.danielwaiguru.domain.use_cases.GetPopularMovieUseCase
import tech.danielwaiguru.domain.use_cases.StoreMovieUseCase

class MovieViewModelFactory(
    private val popularMovieUseCase: GetPopularMovieUseCase,
    private val storeUseCase: StoreMovieUseCase,
    private val localDataUseCase: FetchLocalDataUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(popularMovieUseCase, storeUseCase, localDataUseCase) as T
            }
            else -> throw IllegalArgumentException("Unknown MovieViewModel class")
        }
    }
}