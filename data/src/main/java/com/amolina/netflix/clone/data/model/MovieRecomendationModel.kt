package com.amolina.netflix.clone.data.model

import com.amolina.netflix.clone.domain.model.Movie
import com.amolina.netflix.clone.domain.model.MovieRecommendation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieRecommendationModel(
    val page: Int,

    @SerialName("results")
    val results: List<Result>,

    @SerialName("total_pages")
    val totalPages: Int,

    @SerialName("total_results")
    val totalResults: Int
)

@Serializable
enum class OriginalLanguage {
    CN, EN, HI;

    companion object {
        private val map = values().associateBy { it.name.lowercase() }
        fun fromString(value: String): OriginalLanguage = map[value] ?: throw IllegalArgumentException("Unknown language: $value")
    }
}

fun MovieRecommendationModel.toDomain(): MovieRecommendation {
    return MovieRecommendation(
        page = this.page,
        results = this.results.map { it.toDomain() },
        totalPages = this.totalPages,
        totalResults = this.totalResults
    )
}

fun Result.toDomain(): Movie {
    return Movie(
//        id = this.id,
//        title = this.title,
//        overview = this.overview,
//        releaseDate = this.releaseDate,
        posterPath = this.posterPath,
//        backdropPath = this.backdropPath,
//        voteAverage = this.voteAverage,
//        voteCount = this.voteCount
    )
}