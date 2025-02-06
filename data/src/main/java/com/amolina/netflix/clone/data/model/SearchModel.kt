package com.amolina.netflix.clone.data.model

import com.amolina.netflix.clone.domain.model.Movie
import com.amolina.netflix.clone.domain.model.Search
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

fun SearchModel.toDomain(): Search {
    return Search(
        page = this.page,
        results = this.results.map { it.toDomain() },
        totalPages = this.totalPages,
        totalResults = this.totalResults
    )
}