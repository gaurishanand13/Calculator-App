package com.example.calculator_with_class


class CalcLogic {
    private val OP_ADD = '+'
    private val OP_SUB = '-'
    private val OP_MUL = '*'
    private val OP_DIV = '/'
    //this evaluate function returns a double value
    fun evaluate(num1: Double, num2: Double, currOp: Char): Double {
        //it is a type of switch case the value of the currOp passed is compared.
        //Since we want in every case to give a certain value to result. We could have written it
        // simply is the cases of this switch case. But i showed you that we could have done this way too.
        val result = when (currOp) {
            OP_ADD -> {
                num1 + num2
            }
            OP_SUB -> {
                num1 - num2
            }
            OP_MUL -> {
                num1 * num2
            }
            OP_DIV -> {
                num1 / num2
            }
            else -> {
                throw Exception("Invalid Opertaor")
            }
        }
        return result
    }

}