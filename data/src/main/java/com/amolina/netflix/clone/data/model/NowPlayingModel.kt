package com.amolina.netflix.clone.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class NowPlayingModel(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val totalPages: Int,
    val totalResults: Int
) {
    companion object {
        fun fromRawJson(jsonString: String): NowPlayingModel = Json.decodeFromString(jsonString)
        fun NowPlayingModel.toRawJson(): String = Json.encodeToString(this)
    }
}