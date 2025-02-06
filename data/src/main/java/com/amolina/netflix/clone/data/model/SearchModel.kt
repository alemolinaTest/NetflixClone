package com.amolina.netflix.clone.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class SearchModel(
    val page: Int,
    val results: List<Result>,
    val totalPages: Int,
    val totalResults: Int
) {
    companion object {
        fun fromRawJson(jsonString: String): SearchModel = Json.decodeFromString(jsonString)
        fun SearchModel.toRawJson(): String = Json.encodeToString(this)
    }
}