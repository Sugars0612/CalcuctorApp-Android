package com.sugar.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Operation -> enterOperator(action.operator)
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Delete -> performDelete()
        }
    }

    private fun enterOperator(operator: CalculatorOperator) {
        if (operator != null) {
            state = state.copy(
                operation = operator
            )
        }
    }

    private fun performDelete() {
        // isNotBlank 是 String类函数 会严格检查字符串为空格换行字符串和长度为0
        // Blank 空白的
        state = when {
            // 这里都使用copy是修改引用地址 触发compose的重组
            // dropLast 是 String类函数 参数是丢弃最后几个字符串
            state.number2.isNotBlank() -> state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.operation != null -> state.copy(
                operation = null
            )

            state.number1.isNotBlank() -> state.copy(
                number1 = state.number1.dropLast(1)
            )
            else -> state
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is CalculatorOperator.Add -> number1 + number2
                is CalculatorOperator.Subtraction -> number1 - number2
                is CalculatorOperator.Division -> number1 / number2
                is CalculatorOperator.Multiplication -> number1 * number2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }

    }

    private fun enterDecimal() {
        // contains 是 String类函数 检查是否包含特定字符串
        if (state.operation == null && !state.number1.contains(
                ".") && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }

        if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number2 = state.number2 + "."
            )
            return
        }

    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }

        if (state.number2.length >= MAX_NUM_LENGTH) {
            return
        }

        state = state.copy(
            number2 = state.number2 + number
        )
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}