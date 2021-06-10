package tech.danielwaiguru.domain.use_cases

import tech.danielwaiguru.domain.models.Movie
import tech.danielwaiguru.domain.repository.MovieRepository

class StoreMovieUseCase constructor(private val movieRepo: MovieRepository) {
    suspend operator fun invoke(movies: List<Movie>) = movieRepo.storeMovies(movies)
}