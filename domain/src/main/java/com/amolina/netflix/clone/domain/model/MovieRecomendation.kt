package com.amolina.netflix.clone.domain.model

data class MovieRecommendation(
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)