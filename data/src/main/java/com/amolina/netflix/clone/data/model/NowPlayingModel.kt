package com.amolina.netflix.clone.data.model

import com.amolina.netflix.clone.domain.model.Movie
import com.amolina.netflix.clone.domain.model.NowPlaying
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

fun NowPlayingModel.toDomain(): NowPlaying {
    return NowPlaying(
        page = this.page,
        results = this.results.map { it.toMovieDomain() },
        totalPages = this.totalPages,
        totalResults = this.totalResults
    )
}

fun Result.toMovieDomain(): Movie {
    return Movie(
        id = this.id,
        title = this.title,
        overview = this.overview,
        releaseDate = this.releaseDate,
        posterPath = this.posterPath,
        backdropPath = this.backdropPath,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount
    )
}