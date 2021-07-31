package dev.gtcl.travelbank.presentation.expense.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.gtcl.travelbank.R
import dev.gtcl.travelbank.databinding.FragmentExpenseListBinding
import dev.gtcl.travelbank.domain.model.Expense
import dev.gtcl.travelbank.presentation.expense.list.adapter.ExpenseAdapter
import dev.gtcl.travelbank.presentation.expense.list.adapter.ExpenseClickListener

@AndroidEntryPoint
class ExpenseListFragment: Fragment(R.layout.fragment_expense_list), ExpenseClickListener {

    private var _binding: FragmentExpenseListBinding? = null
    private val binding: FragmentExpenseListBinding
        get() = requireNotNull(_binding)

    private val viewModel: ExpenseListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExpenseListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            expenseListViewModel = viewModel
            lifecycleOwner = viewLifecycleOwner
            expenseList.adapter = ExpenseAdapter(this@ExpenseListFragment)
            swipeRefresh.setOnRefreshListener {
                viewModel.fetchExpenses()
            }
        }

        if(viewModel.expenses.value == null) {
            viewModel.fetchExpenses()
        }

        viewModel.errorMessage.observe(viewLifecycleOwner){
            if(it != null){
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
                viewModel.errorMessageObserved()
            }
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            binding.swipeRefresh.isRefreshing = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Prevent memory leaks
        _binding = null
    }

    override fun onClick(expense: Expense) {
        findNavController().navigate(ExpenseListFragmentDirections.actionShowDetails(expense))
    }

}