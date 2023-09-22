package com.example.challengechapter2.repository

import kotlin.math.ceil

/**
 * Proses kalkulasi tip
 *
 * Logika pemrosesan saat melakukan perhitungan pada fungsi [calculate],
 * dan ketika menghasilkan keluaran pada fungsi [calculateTip]
 *
 * @return [Double] hasil keluaran berupa double
 * */
class Calculation : CalculationImpl {
    override fun calculateTip(
        costOfService: Double,
        tipPercentage: Double,
        roundUp: Boolean
    ): Double {
        return calculate(costOfService, tipPercentage, roundUp)
    }

    private fun calculate(costOfService: Double, tipPercentage: Double, roundUp: Boolean): Double {
        var tipAmount = costOfService * tipPercentage
        if (roundUp) {
            tipAmount = ceil(tipAmount)
        }
        return tipAmount
    }
}

interface CalculationImpl {
    fun calculateTip(costOfService: Double, tipPercentage: Double, roundUp: Boolean): Double {
        return 0.0
    }
}