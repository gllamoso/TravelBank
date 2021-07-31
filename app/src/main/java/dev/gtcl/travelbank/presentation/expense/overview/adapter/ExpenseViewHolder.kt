package dev.gtcl.travelbank.presentation.expense.overview.adapter

import androidx.recyclerview.widget.RecyclerView
import dev.gtcl.travelbank.databinding.ItemExpenseBinding
import dev.gtcl.travelbank.domain.model.Expense

class ExpenseViewHolder(
    private val binding: ItemExpenseBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(expense: Expense, expenseClickListener: ExpenseClickListener){
            binding.expense = expense
            binding.cardView.setOnClickListener {
                expenseClickListener.onClick(expense)
            }
            binding.invalidateAll()
        }
}