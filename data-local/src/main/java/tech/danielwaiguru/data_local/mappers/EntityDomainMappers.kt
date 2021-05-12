package tech.danielwaiguru.data_local.mappers

import tech.danielwaiguru.data_local.models.MovieEntity
import tech.danielwaiguru.domain.models.Movie

fun MovieEntity.toDomain(): Movie {
    return Movie(
            this.id,
            this.language,
            this.overview,
            this.popularity,
            this.poster,
            this.title,
            this.voteCount,
            this.voteAverage,
            this.date
    )
}
fun Movie.toEntity(): MovieEntity {
    return MovieEntity(
            this.id,
            this.language,
            this.overview,
            this.popularity,
            this.poster,
            this.title,
            this.voteCount,
            this.voteAverage,
            this.releaseDate
    )
}