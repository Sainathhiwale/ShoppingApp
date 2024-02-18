package com.examen.shoppingapp.utils

class CommonUtils {
    fun formatPrice(prize: String): String {
        return String.format("%.2f", prize.toDouble())
    }

    fun validateLoginRequest(username: String,password: String) : ValidationResult {
        if (username.isBlank() && password.isBlank()) return ValidationResult(false,"Username and password cannot be blank")
        if (username.isBlank()) return ValidationResult(false,"Username cannot be blank")
        if (password.isBlank()) return ValidationResult(false,"Password cannot be blank")
        return ValidationResult(true)
    }
}