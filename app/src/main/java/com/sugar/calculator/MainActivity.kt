package com.sugar.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sugar.calculator.ui.theme.CalculatorTheme
import com.sugar.calculator.ui.theme.MediumGray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {

//                val viewModel = viewModel<CalculatorViewModel>()
                val viewModel: CalculatorViewModel = viewModel()

                val buttonSpacing = 8.dp

                CalculatorState("1", "2", null)
                Calculator(
                    state = viewModel.state,
                    // ::是可调用引用操作符 直接把函数本身引用的地址传入了进去
                    // fun onAction(action: CalculatorAction): Unit
                    // 可以理解成一种一种语法糖
                    onAction = viewModel::onAction,
                    buttonSpacer = buttonSpacing,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MediumGray)
                        .padding(16.dp)
                )
                

            }
        }
    }
}
