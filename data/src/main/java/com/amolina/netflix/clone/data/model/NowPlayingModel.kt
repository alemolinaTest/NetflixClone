package com.amolina.netflix.clone.data.model

import com.amolina.netflix.clone.domain.model.Movie
import com.amolina.netflix.clone.domain.model.NowPlaying
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NowPlayingModel(
    val dates: Dates,
    val page: Int,
    @SerialName("results")
    val results: List<Result>,

    @SerialName("total_pages")
    val totalPages: Int = 0,

    @SerialName("total_results")
    val totalResults: Int = 0
)

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