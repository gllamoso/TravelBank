package dev.gtcl.travelbank.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Expense(
    val id: String,
    val amount: Float,
    val attachments: List<Attachment>?,
    val date: String,
    val merchantTitle: String,
    val currency: String,
    val category: String
): Parcelable