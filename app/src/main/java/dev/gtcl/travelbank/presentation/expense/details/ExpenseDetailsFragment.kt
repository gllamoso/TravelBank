package dev.gtcl.travelbank.presentation.expense.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import dev.gtcl.travelbank.R
import dev.gtcl.travelbank.databinding.FragmentDetailsBinding

class ExpenseDetailsFragment: Fragment(R.layout.fragment_details) {

    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val expense = ExpenseDetailsFragmentArgs.fromBundle(requireArguments()).expense
        _binding = FragmentDetailsBinding.inflate(inflater).apply {
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

}