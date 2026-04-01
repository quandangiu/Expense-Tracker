package com.example.expensetracker.util

import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

private val amountFormat = DecimalFormat("#,###")
private val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
private val shortDateFormat = SimpleDateFormat("dd MMM", Locale.getDefault())

fun formatAmount(amount: Double): String {
    return "₫ ${amountFormat.format(amount.toLong())}"
}

fun formatDate(timestamp: Long): String {
    return dateFormat.format(Date(timestamp))
}

fun formatDateHeader(timestamp: Long): String {
    val calendar = Calendar.getInstance()
    val today = Calendar.getInstance()

    calendar.timeInMillis = timestamp

    val isToday = calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
            calendar.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR)

    today.add(Calendar.DAY_OF_YEAR, -1)
    val isYesterday = calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
            calendar.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR)

    return when {
        isToday -> "Hôm nay"
        isYesterday -> "Hôm qua"
        else -> dateFormat.format(Date(timestamp))
    }
}
