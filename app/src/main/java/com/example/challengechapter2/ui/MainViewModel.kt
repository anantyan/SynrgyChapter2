package com.example.challengechapter2.ui

import androidx.lifecycle.ViewModel
import com.example.challengechapter2.repository.Calculation
import com.example.challengechapter2.utils.calculate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    private val _tipAmount = MutableStateFlow(0.0)
    val tipAmount: StateFlow<Double> = _tipAmount

    fun calculateTip(costOfService: Double, tipPercentage: Double, roundUp: Boolean) {
        val tipAmount = costOfService.calculate(Calculation(), tipPercentage, roundUp)
        _tipAmount.value = tipAmount
    }
}