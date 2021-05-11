package tech.danielwaiguru.data.mappers

import tech.danielwaiguru.data.models.MovieDto
import tech.danielwaiguru.domain.models.Movie

class JsonResponseToDomain {
    internal fun MovieDto.toDomain(): Movie {
        return Movie(
            this.adult,
            this.id,
            this.language,
            this.originalTitle,
            this.overview,
            this.popularity,
            this.posterPath,
            this.title,
            this.voteCount
        )
    }
}