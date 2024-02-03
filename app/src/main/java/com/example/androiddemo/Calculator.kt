package com.example.androiddemo

class Calculator(
    private val a: Int,
    private val b: Int
) {

    fun sum() = a + b

    fun subtraction() = a - b

    fun multiplication() = a * b

    fun division(): Double {
        if (b == 0) {
            throw Exception("Division by zero")
        }

        return a.toDouble() / b
    }

    fun power() = Math.pow(a.toDouble(), b.toDouble())
}