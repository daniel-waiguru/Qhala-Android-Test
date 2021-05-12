package tech.danielwaiguru.qhalamovies.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tech.danielwaiguru.domain.use_cases.GetMovieDetailsUseCase
import javax.inject.Inject

class MovieDetailViewModelFactory (
        private val detailsUseCase: GetMovieDetailsUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieDetailViewModel::class.java) -> {
                MovieDetailViewModel(detailsUseCase) as T
            }
            else -> throw IllegalArgumentException("Unknown MovieDetailViewModel class")
        }
    }
}