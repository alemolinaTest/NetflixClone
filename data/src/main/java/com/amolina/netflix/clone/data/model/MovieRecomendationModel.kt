package com.amolina.netflix.clone.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class MovieRecommendationModel(
    val page: Int,
    val results: List<Result>,
    val totalPages: Int,
    val totalResults: Int
) {
    fun copyWith(
        page: Int? = null,
        results: List<Result>? = null,
        totalPages: Int? = null,
        totalResults: Int? = null
    ) = MovieRecommendationModel(
        page = page ?: this.page,
        results = results ?: this.results,
        totalPages = totalPages ?: this.totalPages,
        totalResults = totalResults ?: this.totalResults
    )

    companion object {
        fun fromRawJson(jsonString: String): MovieRecommendationModel = Json.decodeFromString(jsonString)
        fun MovieRecommendationModel.toRawJson(): String = Json.encodeToString(this)
    }
}

@Serializable
enum class OriginalLanguage {
    CN, EN, HI;

    companion object {
        private val map = values().associateBy { it.name.lowercase() }
        fun fromString(value: String): OriginalLanguage = map[value] ?: throw IllegalArgumentException("Unknown language: $value")
    }
}