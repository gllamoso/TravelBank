package dev.gtcl.travelbank.presentation.expense.overview.adapter

import androidx.recyclerview.widget.DiffUtil
import dev.gtcl.travelbank.domain.model.Expense

class ExpenseDiffUtil: DiffUtil.ItemCallback<Expense>() {

    override fun areItemsTheSame(oldItem: Expense, newItem: Expense) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Expense, newItem: Expense) = oldItem == newItem

}