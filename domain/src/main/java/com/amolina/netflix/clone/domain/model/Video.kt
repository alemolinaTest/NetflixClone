package com.amolina.netflix.clone.domain.model

data class Video(
    val id: String,
    val videoKey: String, // ✅ YouTube Video ID
    val site: String, // ✅ "YouTube" or other platforms
    val type: String // ✅ "Trailer", "Teaser", etc.
)