# CalculatorApp-Android

一个基于 Jetpack Compose 的安卓计算器应用，用于练习现代 Android UI 与基础架构设计。

------

## 功能

- 基本四则运算（加 / 减 / 乘 / 除）
- 小数运算支持
- 表达式输入与结果计算
- 清空 / 删除操作

------

## 技术栈

- Kotlin
- Jetpack Compose
- MVVM 架构

------

## 架构

项目采用简化的 MVVM 分层结构：

```
UI (Jetpack Compose)
        ↓
    ViewModel
        ↓
    Model / Logic
```

------

## 核心设计

- **State 驱动 UI（UDF）**
- 使用 `State` 管理界面状态
- 通过事件（Event）驱动 ViewModel 逻辑处理
- UI 仅负责渲染状态，不处理业务逻辑

------

## 学习来源

本项目参考以下教程完成：

- [][https://www.youtube.com/watch?v=-aTcFJWxEQA&t=630s]

  [How to Build a Calculator with Jetpack Compose - Android Studio Tutorial](https://www.youtube.com/watch?v=-aTcFJWxEQA&t=630s)

------

## 说明

该项目主要用于学习：

- Jetpack Compose UI 构建
- MVVM 基础架构
- 单向数据流（UDF）
- 状态管理与事件驱动