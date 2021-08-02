package dev.gtcl.travelbank.presentation.fragments.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.gtcl.travelbank.databinding.ItemExpenseBinding
import dev.gtcl.travelbank.domain.model.Expense

class ExpenseViewHolder private constructor(
    private val binding: ItemExpenseBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(expense: Expense, expenseClickListener: ExpenseClickListener){
        binding.expense = expense
        binding.cardView.setOnClickListener {
            expenseClickListener.onClick(expense)
        }
        binding.invalidateAll()
    }

    companion object {
        fun create(parent: ViewGroup) =
            ExpenseViewHolder(ItemExpenseBinding.inflate(LayoutInflater.from(parent.context)))
    }
}