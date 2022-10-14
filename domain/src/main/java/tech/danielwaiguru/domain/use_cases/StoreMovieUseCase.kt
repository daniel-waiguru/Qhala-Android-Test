package tech.danielwaiguru.domain.use_cases

import tech.danielwaiguru.domain.models.Movie
import tech.danielwaiguru.domain.repository.MoviesRepository

class StoreMovieUseCase constructor(private val movieRepo: MoviesRepository) {
    suspend operator fun invoke(movies: List<Movie>) = movieRepo.storeMovies(movies)
}