package dev.gtcl.travelbank.data.model

import com.squareup.moshi.JsonClass
import dev.gtcl.travelbank.domain.model.Attachment
import dev.gtcl.travelbank.domain.model.Expense
import java.util.*

@JsonClass(generateAdapter = true)
data class ExpenseRemote(
    val id: String,
    val amount: Float,
    val attachments: List<AttachmentRemote>?,
    val date: String,
    val expenseVenueTitle: String,
    val currencyCode: String,
    val tripBudgetCategory: String
) {

    fun toDomain() = Expense(
        id,
        amount,
        attachments?.map { Attachment(it.mime, it.thumbnails.list, it.thumbnails.full) },
        date,
        expenseVenueTitle,
        currencyCode,
        tripBudgetCategory.capitalize(Locale.ROOT)
    )

}