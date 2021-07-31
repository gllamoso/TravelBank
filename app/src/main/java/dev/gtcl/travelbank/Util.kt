package dev.gtcl.travelbank

import android.text.Spannable
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import java.text.SimpleDateFormat
import java.util.*

val REMOTE_DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
val MONTH_DAY_FORMAT = SimpleDateFormat("MMM dd", Locale.US)
val MONTH_DAY_YEAR_FORMAT = SimpleDateFormat("MMM dd, yyyy", Locale.US)

fun convertRemoteDateToMonthDayAndYear(remoteDate: String): String{
    val date = REMOTE_DATE_FORMAT.parse(remoteDate)!!
    return MONTH_DAY_YEAR_FORMAT.format(date)
}

fun convertRemoteDateToMonthAndDay(remoteDate: String): String{
    val date = REMOTE_DATE_FORMAT.parse(remoteDate)!!
    return MONTH_DAY_FORMAT.format(date)
}

fun Float.formatToDollars() = SpannableString(String.format("$%,.2f", this))

fun Float.formatToDollarsWithSuperScript() = this.formatToDollars().apply {
    setSpan(CustomSuperscriptSpan(), length - 3, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    setSpan(RelativeSizeSpan(0.75f), length - 3, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
}