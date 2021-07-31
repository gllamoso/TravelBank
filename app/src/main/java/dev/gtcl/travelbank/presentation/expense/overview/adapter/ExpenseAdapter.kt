package dev.gtcl.travelbank.presentation.expense.overview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import dev.gtcl.travelbank.databinding.ItemExpenseBinding
import dev.gtcl.travelbank.domain.model.Expense

class ExpenseAdapter(private val expenseClickListener: ExpenseClickListener) : ListAdapter<Expense, ExpenseViewHolder>(ExpenseDiffUtil()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemExpenseBinding.inflate(inflater, parent, false)
        return ExpenseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        holder.bind(getItem(position), expenseClickListener)
    }
}