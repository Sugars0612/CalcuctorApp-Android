package com.sugar.calculator

sealed class CalculatorAction {
    data class Number(val number: Int) : CalculatorAction()
    data class Operation(val operator: CalculatorOperator): CalculatorAction()

    object Clear: CalculatorAction()
    object Delete: CalculatorAction()
    object Decimal: CalculatorAction() // 十进制
    object Calculate: CalculatorAction() // 运算
}