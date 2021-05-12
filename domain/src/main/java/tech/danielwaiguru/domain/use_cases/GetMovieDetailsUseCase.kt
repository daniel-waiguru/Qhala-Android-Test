package tech.danielwaiguru.domain.use_cases

import tech.danielwaiguru.domain.repository.MovieRepository

class GetMovieDetailsUseCase constructor(private val movieRepo: MovieRepository) {
    suspend operator fun invoke(mId: Int) = movieRepo.getMovieDetails(mId)
}