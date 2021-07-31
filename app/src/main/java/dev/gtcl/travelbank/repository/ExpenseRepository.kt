package dev.gtcl.travelbank.repository

import dev.gtcl.travelbank.domain.model.Expense

interface ExpenseRepository {
    suspend fun getExpenses(): List<Expense>
}