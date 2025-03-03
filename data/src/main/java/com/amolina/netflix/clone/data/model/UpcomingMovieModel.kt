package com.amolina.netflix.clone.data.model

import com.amolina.netflix.clone.domain.model.UpcomingMovies
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpcomingMovieModel(
    val dates: Dates,
    val page: Int,
    @SerialName("results")
    val results: List<Result>,

    @SerialName("total_pages")
    val totalPages: Int = 0,

    @SerialName("total_results")
    val totalResults: Int = 0
)

fun UpcomingMovieModel.toDomain(): UpcomingMovies {
    return UpcomingMovies(
        dates = this.dates.toDates(),
        page = this.page,
        results = this.results.map { it.toDomain() },
        totalPages = this.totalPages,
        totalResults = this.totalResults
    )
}

