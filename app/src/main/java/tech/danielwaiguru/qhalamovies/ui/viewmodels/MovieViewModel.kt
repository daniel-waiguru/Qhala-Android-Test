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
import tech.danielwaiguru.domain.use_cases.GetPopularMovieUseCase
import tech.danielwaiguru.qhalamovies.models.ResultWrapper
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val popularMovieUseCase: GetPopularMovieUseCase): ViewModel() {
    private val _responseState: MutableLiveData<ResultWrapper<List<Movie>>> = MutableLiveData()
    val responseState: LiveData<ResultWrapper<List<Movie>>> get() = _responseState
    init {
        fetchPopularMovies()
        fetchCachedData()
    }
    private fun fetchPopularMovies() {
        viewModelScope.launch {
            popularMovieUseCase.invoke()
                .onStart {
                    //emit loading state
                    _responseState.value = ResultWrapper.Loading
                }
                .catch { exception ->
                    //emit error state
                    _responseState.value = ResultWrapper.Error(exception.message, exception)
                }
                .collect { movies ->
                    //emit success state
                    //_responseState.value = ResultWrapper.Success(movies)
                }
        }
    }
    private fun fetchCachedData() {
        viewModelScope.launch {
            popularMovieUseCase.invoke()
                    .catch { exception ->
                        //emit error state
                        _responseState.value = ResultWrapper.Error(exception.message, exception)
                    }
                    .collect {
                        _responseState.value = ResultWrapper.Success(it)
                    }
        }
    }
}