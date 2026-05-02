package com.sugar.calculator

sealed class CalculatorOperator(val symbol: String) {
    object Add: CalculatorOperator("+")
    object Subtraction: CalculatorOperator("-")
    object Multiplication: CalculatorOperator("*")
    object Division: CalculatorOperator("/")
}