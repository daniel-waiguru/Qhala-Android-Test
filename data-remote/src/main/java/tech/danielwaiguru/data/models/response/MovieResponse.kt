package tech.danielwaiguru.data.models.response

import com.squareup.moshi.Json

data class MovieResponse(
    @field:Json(name = "results")val results: List<MovieResponse>
)