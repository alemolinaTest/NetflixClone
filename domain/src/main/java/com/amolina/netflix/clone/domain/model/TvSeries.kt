package com.amolina.netflix.clone.domain.model

data class TvSeries(
    val page: Int,
    val results: List<TvShow>,
    val totalPages: Int,
    val totalResults: Int
)

data class TvShow(
    val id: Int,
    val overview: String,
    val posterPath: String?,
    val backdropPath: String?,
    val voteAverage: Double,
    val voteCount: Int
)