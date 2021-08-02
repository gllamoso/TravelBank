package dev.gtcl.travelbank.presentation.fragments.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.gtcl.travelbank.R
import dev.gtcl.travelbank.databinding.FragmentExpenseDetailsBinding

class ExpenseDetailsFragment: Fragment(R.layout.fragment_expense_details) {

    private var _binding: FragmentExpenseDetailsBinding? = null
    private val binding: FragmentExpenseDetailsBinding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val expense = ExpenseDetailsFragmentArgs.fromBundle(requireArguments()).expense
        _binding = FragmentExpenseDetailsBinding.inflate(inflater).apply {
            this.expense = expense
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.toolbar.apply {
            setNavigationIcon(R.drawable.ic_close_24)
            setNavigationOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Prevent memory leaks
        _binding = null
    }
}