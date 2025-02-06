package com.amolina.netflix.clone.data.model

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