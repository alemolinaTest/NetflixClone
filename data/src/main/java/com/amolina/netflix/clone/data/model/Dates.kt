package com.amolina.netflix.clone.data.model

import kotlinx.serialization.Serializable


@Serializable
data class Dates(
    val maximum: String,
    val minimum: String
)


fun Dates.toDates(): com.amolina.netflix.clone.domain.model.Dates {
    return com.amolina.netflix.clone.domain.model.Dates(
        maximum = this.maximum,
        minimum = this.minimum
    )
}