package tech.danielwaiguru.domain.use_cases

import tech.danielwaiguru.domain.repository.MoviesRepository

class GetPopularMovieUseCase(private val movieRepo: MoviesRepository) {
    operator fun invoke() = movieRepo.getMovies()
}