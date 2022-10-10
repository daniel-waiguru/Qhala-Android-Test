package tech.danielwaiguru.qhalamovies.ui.viewmodels

import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import tech.danielwaiguru.domain.use_cases.GetMovieDetailsUseCase
import tech.danielwaiguru.qhalamovies.base.BaseViewModelTest
import tech.danielwaiguru.qhalamovies.ui.movie_details.MovieDetailViewModel

class MovieDetailViewModelTest: BaseViewModelTest() {
    private lateinit var detailViewModel: MovieDetailViewModel
    private val detailsUseCase: GetMovieDetailsUseCase = mock()

    @Before
    fun setup() {
        val savedStateHandle = SavedStateHandle().apply {
            set(MovieDetailViewModel.MOVIE_ID_KEY, 1)
        }
        detailViewModel = MovieDetailViewModel(detailsUseCase, savedStateHandle)
    }
    @Test
    fun `call to fetch particular movie details invokes use case with correct id`() = runTest {
        verify(detailsUseCase).invoke(1)
    }
}