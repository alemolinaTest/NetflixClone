package com.amolina.netflix.clone.domain.model

data class Dates(
    val maximum: String,
    val minimum: String
)

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val posterPath: String?,
    val backdropPath: String?,
    val voteAverage: Double,
    val voteCount: Int
)