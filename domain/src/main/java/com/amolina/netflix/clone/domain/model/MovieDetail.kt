package com.amolina.netflix.clone.domain.model

data class MovieDetail(
    val id: Int,
    val title: String,
    val overview: String,
    val releaseDate: String?,
    val posterPath: String?,
    val backdropPath: String?,
    val genres: List<String>,
    val runtime: Int,
    val voteAverage: Double,
    val voteCount: Int
)