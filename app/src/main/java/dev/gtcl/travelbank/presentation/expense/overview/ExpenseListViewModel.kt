package dev.gtcl.travelbank.presentation.expense.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.gtcl.travelbank.EspressoIdlingResource
import dev.gtcl.travelbank.domain.model.Expense
import dev.gtcl.travelbank.repository.ExpenseRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpenseListViewModel @Inject constructor(
    private val expenseRepository: ExpenseRepository
): ViewModel() {

    private val _expenses = MutableLiveData<List<Expense>>()
    val expenses: LiveData<List<Expense>>
        get() = _expenses

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?>
        get() = _errorMessage

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    private val _total = MutableLiveData<Float>()
    val total: LiveData<Float>
        get() = _total

    fun fetchExpenses(){
        viewModelScope.launch {
            try {
                EspressoIdlingResource.increment()
                _loading.value = true
                _expenses.value = listOf()
                _expenses.value = expenseRepository.getExpenses()
                _total.value = _expenses.value?.map { it.amount }?.sum()
            } catch (e: Exception) {
                _errorMessage.value = e.toString()
            } finally {
                _loading.value = false
                EspressoIdlingResource.decrement()
            }
        }
    }

    fun errorMessageObserved(){
        _errorMessage.value = null
    }

}