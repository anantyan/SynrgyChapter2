package com.example.challengechapter2.common

import com.example.challengechapter2.repository.Calculation

/**
 * Implementasi pada UI Layer untuk kalkulasi tip
 *
 * @param calculationImpl inject dari fungsi [Calculation]
 * @param tipPercentage inputan berupa tip persen [Double]
 * @param roundUp inputan apakah ingin tipnya digenapkan atau tidak dengan inputan [Boolean]
 *
 * @return [Double] hasil keluaran maka hasil dari kalkulasi pada class [Calculation]
 * */
fun Double.calculate(calculation: Calculation, tipPercentage: Double, roundUp: Boolean): Double {
    return calculation.calculateTip(this, tipPercentage, roundUp)
}