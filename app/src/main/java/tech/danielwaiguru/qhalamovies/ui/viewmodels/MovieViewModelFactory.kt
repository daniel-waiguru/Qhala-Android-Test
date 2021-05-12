package tech.danielwaiguru.qhalamovies.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tech.danielwaiguru.domain.use_cases.GetPopularMovieUseCase

class MovieViewModelFactory(
    private val popularMovieUseCase: GetPopularMovieUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(popularMovieUseCase) as T
            }
            else -> throw IllegalArgumentException("Unknown exception class")
        }
    }
}