package com.example.challengechapter2.utils

import com.example.challengechapter2.repository.Calculation
import com.example.challengechapter2.repository.CalculationImpl

/**
 * Implementasi pada UI Layer untuk kalkulasi tip
 *
 * @param calculationImpl inject dari fungsi [Calculation]
 * @param tipPercentage inputan berupa tip persen [Double]
 * @param roundUp inputan apakah ingin tipnya digenapkan atau tidak dengan inputan [Boolean]
 *
 * @return [Double] hasil keluaran maka hasil dari kalkulasi pada class [Calculation]
 * */
fun Double.calculate(calculationImpl: CalculationImpl, tipPercentage: Double, roundUp: Boolean): Double {
    return calculationImpl.calculateTip(this, tipPercentage, roundUp)
}