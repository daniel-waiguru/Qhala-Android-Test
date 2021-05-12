package tech.danielwaiguru.domain.models

data class Movie(
    val adult: Boolean,
    val id: Int,
    val language: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val poster: String,
    val title: String,
    val voteCount: Int,
    val voteAverage: Double
)
