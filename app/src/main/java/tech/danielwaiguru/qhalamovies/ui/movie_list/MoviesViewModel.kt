package tech.danielwaiguru.qhalamovies.ui.movie_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import tech.danielwaiguru.domain.models.Movie
import tech.danielwaiguru.domain.use_cases.GetPopularMovieUseCase
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val popularMovieUseCase: GetPopularMovieUseCase,
): ViewModel() {
    fun getPopularMovies(): Flow<PagingData<Movie>> {
        return popularMovieUseCase()
            .cachedIn(viewModelScope)
    }
}