package tech.danielwaiguru.domain.models

import tech.danielwaiguru.domain.common.Constants.IMAGE_PREFIX

data class Movie(
    val id: Int,
    val language: String,
    val overview: String,
    val popularity: Double,
    val poster: String,
    val title: String,
    val voteCount: Int,
    val voteAverage: Double,
    val releaseDate: String
){
    val posterPath
    get() = "$IMAGE_PREFIX${poster}"
}
