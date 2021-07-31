package dev.gtcl.travelbank.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AttachmentRemote(
    val mime: String,
    val thumbnails: ThumbnailsRemote
)