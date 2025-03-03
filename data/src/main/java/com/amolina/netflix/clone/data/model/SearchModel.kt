package com.amolina.netflix.clone.data.model

import com.amolina.netflix.clone.domain.model.Search
import kotlinx.serialization.Serializable

@Serializable
data class SearchModel(
    val page: Int,
    val results: List<Result>,
    val totalPages: Int,
    val totalResults: Int
)

fun SearchModel.toDomain(): Search {
    return Search(
        page = this.page,
        results = this.results.map { it.toDomain() },
        totalPages = this.totalPages,
        totalResults = this.totalResults
    )
}