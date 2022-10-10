package tech.danielwaiguru.qhalamovies.ui.movie_details

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import tech.danielwaiguru.domain.common.ResultWrapper
import tech.danielwaiguru.domain.models.Movie
import tech.danielwaiguru.domain.use_cases.GetMovieDetailsUseCase
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
        private val detailsUseCase: GetMovieDetailsUseCase,
        savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _movieState: MutableLiveData<ResultWrapper<Movie>> = MutableLiveData()
    val movieState: LiveData<ResultWrapper<Movie>> get() = _movieState
    init {
        savedStateHandle.get<Int>(MOVIE_ID_KEY)?.let { movieId ->
            getMovie(movieId)
        }
    }
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private fun getMovie(movieId: Int) {
        viewModelScope.launch {
            detailsUseCase(movieId)
                    .onStart {
                        //emit loading state
                        _movieState.value = ResultWrapper.Loading
                    }
                    .catch { exception ->
                        _movieState.value = ResultWrapper
                                .Error(exception.message.toString(), exception)
                    }
                    .collect {
                        _movieState.value = ResultWrapper.Success(it)
                    }
        }
    }
    companion object {
        const val MOVIE_ID_KEY = "movieId"
    }
}