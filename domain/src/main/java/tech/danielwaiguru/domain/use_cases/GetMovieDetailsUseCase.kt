package tech.danielwaiguru.domain.use_cases

import tech.danielwaiguru.domain.repository.MoviesRepository

class GetMovieDetailsUseCase constructor(private val movieRepo: MoviesRepository) {
    suspend operator fun invoke(mId: Int) = movieRepo.getMovieDetails(mId)
}