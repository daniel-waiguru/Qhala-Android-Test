package tech.danielwaiguru.data.mappers

import tech.danielwaiguru.data.models.MovieDto
import tech.danielwaiguru.data_local.models.MovieEntity

internal fun MovieDto.toEntity(): MovieEntity =
    MovieEntity(
        id = id,
        language = language,
        overview = overview,
        popularity = popularity,
        poster = posterPath,
        title = title,
        voteAverage = voteAverage,
        voteCount = voteCount,
        date = releaseDate
    )
