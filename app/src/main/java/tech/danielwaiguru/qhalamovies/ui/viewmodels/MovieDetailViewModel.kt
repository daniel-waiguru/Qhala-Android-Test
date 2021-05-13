package tech.danielwaiguru.qhalamovies.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import tech.danielwaiguru.domain.models.Movie
import tech.danielwaiguru.domain.use_cases.GetMovieDetailsUseCase
import tech.danielwaiguru.qhalamovies.models.ResultWrapper
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
        private val detailsUseCase: GetMovieDetailsUseCase
): ViewModel() {
    private val _movieState: MutableLiveData<ResultWrapper<Movie>> = MutableLiveData()
    val movieState: LiveData<ResultWrapper<Movie>> get() = _movieState
    fun fetchMovieDetails(mId: Int) {
        viewModelScope.launch {
            detailsUseCase.invoke(mId)
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
}