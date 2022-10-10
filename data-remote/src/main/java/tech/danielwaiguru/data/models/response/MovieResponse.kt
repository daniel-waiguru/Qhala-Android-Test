package tech.danielwaiguru.data.models.response

import com.squareup.moshi.Json
import tech.danielwaiguru.data.models.MovieDto

data class MovieResponse(
    @field:Json(name = "results") val results: List<MovieDto>
)