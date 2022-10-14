package tech.danielwaiguru.domain.use_cases

import tech.danielwaiguru.domain.repository.MoviesRepository

class FetchLocalDataUseCase(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke() = moviesRepository.fetCachedData()
}