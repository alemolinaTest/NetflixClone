package com.amolina.netflix.clone.data.model

import com.amolina.netflix.clone.domain.model.TvSeries
import com.amolina.netflix.clone.domain.model.TvShow
import kotlinx.serialization.Serializable

@Serializable
data class TvSeriesModel(
    val page: Int,
    val results: List<Result>,
    val totalPages: Int,
    val totalResults: Int
)

fun TvSeriesModel.toDomain(): TvSeries {
    return TvSeries(
        page = this.page,
        results = this.results.map { it.toShowDomain() },
        totalPages = this.totalPages,
        totalResults = this.totalResults
    )
}

fun Result.toShowDomain(): TvShow {
    return TvShow(
        id = this.id,
        overview = this.overview,
        posterPath = this.posterPath,
        backdropPath = this.backdropPath,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount
    )
}