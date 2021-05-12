package tech.danielwaiguru.domain.use_cases

import tech.danielwaiguru.domain.repository.MovieRepository

class GetPopularMovieUseCase constructor(private val movieRepo: MovieRepository) {
    suspend operator fun invoke() = movieRepo.getPopularMovies()
}