package com.amolina.netflix.clone.data.model

import com.amolina.netflix.clone.domain.model.UpcomingMovies
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpcomingMovieModel(
    val dates: Dates,
    val page: Int,
    @SerialName("results")
    val results: List<Result>,

    @SerialName("total_pages")
    val totalPages: Int = 0, // ✅ Default value added

    @SerialName("total_results")
    val totalResults: Int = 0 // ✅ Default value added
)

@Serializable
data class Dates(
    val maximum: String,
    val minimum: String
)


@Serializable
data class Result(
    //val adult: Boolean,

//    @SerialName("backdrop_path")
//    val backdropPath: String?,
//
//    @SerialName("genre_ids")
//    val genreIds: List<Int>?,

    //val id: Int,

    //val name: String,

//    @SerialName("original_language")
//    val originalLanguage: String?,
//
//    @SerialName("original_title")
//    val originalTitle: String?,
//
//    val overview: String,
//    val popularity: Double,

    @SerialName("poster_path")
    val posterPath: String?,

//    @SerialName("release_date")
//    val releaseDate: String?,
//
//    @SerialName("first_air_date")
//    val firstAirDate: String?,
//
//    val title: String,
//    val video: Boolean,
//
//    @SerialName("vote_average")
//    val voteAverage: Double,
//
//    @SerialName("vote_count")
//    val voteCount: Int
)


fun UpcomingMovieModel.toDomain(): UpcomingMovies {
    return UpcomingMovies(
        dates = this.dates.toDates(),
        page = this.page,
        results = this.results.map { it.toDomain() },
        totalPages = this.totalPages,
        totalResults = this.totalResults
    )
}

fun Dates.toDates(): com.amolina.netflix.clone.domain.model.Dates {
    return com.amolina.netflix.clone.domain.model.Dates(
        maximum = this.maximum,
        minimum = this.minimum
    )
}
