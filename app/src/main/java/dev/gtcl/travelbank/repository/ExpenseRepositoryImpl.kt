package dev.gtcl.travelbank.repository

import dev.gtcl.travelbank.data.network.service.ExpenseService
import javax.inject.Inject

class ExpenseRepositoryImpl @Inject constructor(
    private val expenseService: ExpenseService
): ExpenseRepository {

    override suspend fun getExpenses() = expenseService.getExpenseList().map { it.toDomain() }

}