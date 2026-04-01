package com.example.expensetracker.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object AddExpense : Screen("add_expense")
    data object Summary : Screen("summary")
}
