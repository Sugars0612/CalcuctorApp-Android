package com.sugar.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sugar.calculator.ui.theme.LightGray
import com.sugar.calculator.ui.theme.Orange

@Composable
fun Calculator(
    state: CalculatorState,
    buttonSpacer: Dp,
    modifier: Modifier = Modifier,
    onAction: (CalculatorAction) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
//            .background(Color.DarkGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
//                .background(Color.DarkGray)
                .align(Alignment.BottomCenter), verticalArrangement = spacedBy(buttonSpacer)
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )

            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = spacedBy(buttonSpacer)
            ) {
                CalculatorButton(
                    symbol = "AC",
                    onClick = { onAction(CalculatorAction.Clear) },
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(2f)
                        .weight(2f)
                )
                CalculatorButton(
                    symbol = "Del",
                    onClick = { onAction(CalculatorAction.Delete) },
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "/",
                    onClick = { onAction(CalculatorAction.Operation(CalculatorOperator.Division)) },
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = spacedBy(buttonSpacer)
            ) {
                CalculatorButton(
                    symbol = "7",
                    onClick = { onAction(CalculatorAction.Number(7)) },
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "8",
                    onClick = { onAction(CalculatorAction.Number(8)) },
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "9",
                    onClick = { onAction(CalculatorAction.Number(9)) },
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "x",
                    onClick = { onAction(CalculatorAction.Operation(CalculatorOperator.Multiplication)) },
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = spacedBy(buttonSpacer)
            ) {
                CalculatorButton(
                    symbol = "4",
                    onClick = { onAction(CalculatorAction.Number(4)) },
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "5",
                    onClick = { onAction(CalculatorAction.Number(5)) },
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "6",
                    onClick = { onAction(CalculatorAction.Number(6)) },
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "-",
                    onClick = { onAction(CalculatorAction.Operation(CalculatorOperator.Subtraction)) },
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = spacedBy(buttonSpacer)
            ) {
                CalculatorButton(
                    symbol = "1",
                    onClick = { onAction(CalculatorAction.Number(1)) },
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "2",
                    onClick = { onAction(CalculatorAction.Number(2)) },
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "3",
                    onClick = { onAction(CalculatorAction.Number(3)) },
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "+",
                    onClick = { onAction(CalculatorAction.Operation(CalculatorOperator.Add)) },
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = spacedBy(buttonSpacer)
            ) {
                CalculatorButton(
                    symbol = "0",
                    onClick = { onAction(CalculatorAction.Number(0)) },
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(2f)
                        .weight(2f)
                )
                CalculatorButton(
                    symbol = ".",
                    onClick = { onAction(CalculatorAction.Decimal) },
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "=",
                    onClick = { onAction(CalculatorAction.Calculate) },
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                )

            }
        }
    }
}
