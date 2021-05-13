package tech.danielwaiguru.data.mappers

import tech.danielwaiguru.data.models.MovieDto
import tech.danielwaiguru.domain.models.Movie


internal fun MovieDto.toDomain(): Movie {
    return Movie(
        this.id,
        this.language,
        this.overview,
        this.popularity,
        this.posterPath,
        this.title,
        this.voteCount,
        this.voteAverage,
        this.releaseDate
    )
}