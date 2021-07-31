package dev.gtcl.travelbank.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Attachment(
    val mime: String,
    val thumbnailList: String,
    val thumbnailFull: String
): Parcelable