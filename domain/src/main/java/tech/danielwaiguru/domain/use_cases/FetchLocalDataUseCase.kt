package tech.danielwaiguru.domain.use_cases

import tech.danielwaiguru.domain.repository.MovieRepository

class FetchLocalDataUseCase constructor(private val movieRepository: MovieRepository) {
    suspend operator fun invoke() = movieRepository.fetCachedData()
}