package dev.gtcl.travelbank.presentation.expense.overview.adapter

import dev.gtcl.travelbank.domain.model.Expense

interface ExpenseClickListener {
    fun onClick(expense: Expense)
}