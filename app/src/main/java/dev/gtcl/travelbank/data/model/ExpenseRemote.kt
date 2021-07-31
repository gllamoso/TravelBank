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
        id = id,
        amount = amount,
        attachments = attachments?.map { Attachment(it.mime, it.thumbnails.list, it.thumbnails.full) },
        date = date,
        merchantTitle = expenseVenueTitle,
        currency = currencyCode,
        category = tripBudgetCategory.capitalize(Locale.ROOT)
    )

}