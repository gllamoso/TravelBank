package dev.gtcl.travelbank

import java.text.SimpleDateFormat
import java.util.*

val REMOTE_DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
val MONTH_DAY_FORMAT = SimpleDateFormat("MMM d", Locale.US)
val MONTH_DAY_YEAR_FORMAT = SimpleDateFormat("MMM d, yyyy", Locale.US)

fun convertRemoteDateToMonthDayAndYear(remoteDate: String): String{
    val date = REMOTE_DATE_FORMAT.parse(remoteDate)!!
    return MONTH_DAY_YEAR_FORMAT.format(date)
}

fun convertRemoteDateToMonthAndDay(remoteDate: String): String{
    val date = REMOTE_DATE_FORMAT.parse(remoteDate)!!
    return MONTH_DAY_FORMAT.format(date)
}

fun Float.toDollars() = String.format("$%,.2f", this)