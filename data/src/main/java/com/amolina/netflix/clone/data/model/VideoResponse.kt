package com.amolina.netflix.clone.data.model

import com.amolina.netflix.clone.domain.model.Movie
import com.amolina.netflix.clone.domain.model.Video
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoResponseModel(
    @SerialName("results")
    val results: List<VideoResponse>
)

@Serializable
data class VideoResponse(
    val id: String,
    @SerialName("key")
    val videoKey: String, // ✅ YouTube Video ID
    @SerialName("site")
    val site: String, // ✅ "YouTube" or other platforms
    @SerialName("type")
    val type: String // ✅ "Trailer", "Teaser", etc.
)
fun VideoResponseModel.toVideoDomainList(): List<Video>{
    val list = results.map { it.toVideoDomain() }
    return list
}

fun VideoResponse.toVideoDomain(): Video {
    return Video(
        id= this.id,
        videoKey = this.videoKey,
        site = this.site,
        type = this.type

    )
}