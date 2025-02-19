package com.amolina.netflix.clone.domain.model

data class NowPlaying(
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int?,
    val totalResults: Int?
)

