package com.amolina.netflix.clone.data.model

import com.amolina.netflix.clone.domain.model.TvSeries
import com.amolina.netflix.clone.domain.model.TvShow
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class TvSeriesModel(
    val page: Int,
    val results: List<Result>,
    val totalPages: Int,
    val totalResults: Int
) {
    companion object {
        fun fromRawJson(jsonString: String): TvSeriesModel = Json.decodeFromString(jsonString)
        fun TvSeriesModel.toRawJson(): String = Json.encodeToString(this)
    }
}

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
        name = this.name,
        overview = this.overview,
        firstAirDate = this.firstAirDate,
        posterPath = this.posterPath,
        backdropPath = this.backdropPath,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount
    )
}