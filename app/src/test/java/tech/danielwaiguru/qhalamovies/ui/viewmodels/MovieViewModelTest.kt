package tech.danielwaiguru.qhalamovies.ui.viewmodels

import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import tech.danielwaiguru.domain.use_cases.FetchLocalDataUseCase
import tech.danielwaiguru.domain.use_cases.GetPopularMovieUseCase
import tech.danielwaiguru.domain.use_cases.StoreMovieUseCase
import tech.danielwaiguru.qhalamovies.base.BaseViewModelTest
import tech.danielwaiguru.qhalamovies.ui.movie_list.MovieViewModel

class MovieViewModelTest: BaseViewModelTest() {
    private lateinit var movieViewModel: MovieViewModel
    private val popularMovieUseCase: GetPopularMovieUseCase = mock()
    private val storeUseCase: StoreMovieUseCase = mock()
    private val fetchLocalDataUseCase: FetchLocalDataUseCase = mock()

    @Before
    fun setup() {
        movieViewModel = MovieViewModel(popularMovieUseCase, storeUseCase, fetchLocalDataUseCase)
    }
    /*@Test
    fun `call to fetch a list of movies`() = runBlockingTest {
        movieViewModel.fetchPopularMovies()
        verify(popularMovieUseCase).invoke()
    }*/

    @Test
    fun `call to fetch local movies`() = runBlockingTest {
        movieViewModel.fetchCachedData()
        verify(popularMovieUseCase).invoke()
    }
}