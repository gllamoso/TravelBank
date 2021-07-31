package dev.gtcl.travelbank.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ThumbnailsRemote(
    val full: String,
    val list: String
)