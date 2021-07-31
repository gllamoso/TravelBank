package dev.gtcl.travelbank.presentation.expense.overview

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
import dev.gtcl.travelbank.databinding.FragmentListBinding
import dev.gtcl.travelbank.domain.model.Expense
import dev.gtcl.travelbank.presentation.expense.overview.adapter.ExpenseAdapter
import dev.gtcl.travelbank.presentation.expense.overview.adapter.ExpenseClickListener

@AndroidEntryPoint
class ExpenseOverviewFragment: Fragment(R.layout.fragment_list), ExpenseClickListener {

    private var _binding: FragmentListBinding? = null
    private val binding: FragmentListBinding
        get() = requireNotNull(_binding)

    private val viewModel: ExpenseOverviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            expenseOverviewViewModel = viewModel
            lifecycleOwner = viewLifecycleOwner
            expenseList.adapter = ExpenseAdapter(this@ExpenseOverviewFragment)
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
        findNavController().navigate(ExpenseOverviewFragmentDirections.actionShowDetails(expense))
    }
}