package dev.gtcl.travelbank.presentation.fragments.list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import dev.gtcl.travelbank.domain.model.Expense

class ExpenseAdapter(
    private val expenseClickListener: ExpenseClickListener
) : ListAdapter<Expense, ExpenseViewHolder>(ExpenseDiffUtil()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ExpenseViewHolder.create(parent)

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        holder.bind(getItem(position), expenseClickListener)
    }

}