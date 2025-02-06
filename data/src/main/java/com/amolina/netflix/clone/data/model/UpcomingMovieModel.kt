package com.amolina.netflix.clone.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class UpcomingMovieModel(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val totalPages: Int,
    val totalResults: Int
) {
    fun copyWith(
        dates: Dates? = null,
        page: Int? = null,
        results: List<Result>? = null,
        totalPages: Int? = null,
        totalResults: Int? = null
    ) = UpcomingMovieModel(
        dates = dates ?: this.dates,
        page = page ?: this.page,
        results = results ?: this.results,
        totalPages = totalPages ?: this.totalPages,
        totalResults = totalResults ?: this.totalResults
    )

    companion object {
        fun fromRawJson(jsonString: String): UpcomingMovieModel = Json.decodeFromString(jsonString)
        fun UpcomingMovieModel.toRawJson(): String = Json.encodeToString(this)
    }
}

@Serializable
data class Dates(
    val maximum: String,
    val minimum: String
)

@Serializable
data class Result(
    val adult: Boolean,
    val backdropPath: String?,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
) {
    fun copyWith(
        adult: Boolean? = null,
        backdropPath: String? = null,
        genreIds: List<Int>? = null,
        id: Int? = null,
        originalLanguage: String? = null,
        originalTitle: String? = null,
        overview: String? = null,
        popularity: Double? = null,
        posterPath: String? = null,
        releaseDate: String? = null,
        title: String? = null,
        video: Boolean? = null,
        voteAverage: Double? = null,
        voteCount: Int? = null
    ) = Result(
        adult = adult ?: this.adult,
        backdropPath = backdropPath ?: this.backdropPath,
        genreIds = genreIds ?: this.genreIds,
        id = id ?: this.id,
        originalLanguage = originalLanguage ?: this.originalLanguage,
        originalTitle = originalTitle ?: this.originalTitle,
        overview = overview ?: this.overview,
        popularity = popularity ?: this.popularity,
        posterPath = posterPath ?: this.posterPath,
        releaseDate = releaseDate ?: this.releaseDate,
        title = title ?: this.title,
        video = video ?: this.video,
        voteAverage = voteAverage ?: this.voteAverage,
        voteCount = voteCount ?: this.voteCount
    )
}
