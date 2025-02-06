package com.amolina.netflix.clone.data.model

import com.amolina.netflix.clone.domain.model.MovieDetail
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class MovieDetailModel(
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: BelongsToCollection,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompany>,
    val productionCountries: List<ProductionCountry>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
) {
    companion object {
        fun fromRawJson(jsonString: String): MovieDetailModel = Json.decodeFromString(jsonString)
        fun MovieDetailModel.toRawJson(): String = Json.encodeToString(this)
    }
}

@Serializable
data class Genre(
    val id: Int,
    val name: String
)

@Serializable
data class ProductionCompany(
    val id: Int,
    val logoPath: String?,
    val name: String,
    val originCountry: String
)

@Serializable
data class ProductionCountry(
    val iso31661: String,
    val name: String
)

@Serializable
data class SpokenLanguage(
    val englishName: String,
    val iso6391: String,
    val name: String
)

@Serializable
data class BelongsToCollection(
    val id: Int,
    val name: String,
    val posterPath: String?,
    val backdropPath: String?
)

fun MovieDetailModel.toDomain(): MovieDetail {
    return MovieDetail(
        id = this.id,
        title = this.title,
        overview = this.overview,
        releaseDate = this.releaseDate,
        posterPath = this.posterPath,
        backdropPath = this.backdropPath,
        genres = this.genres.map { it.name },
        runtime = this.runtime,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount
    )
}