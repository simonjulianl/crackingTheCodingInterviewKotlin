package chapterSixteenMedium

import java.util.*
import kotlin.math.exp

enum class Operator {
    ADD,
    SUB,
    MUL,
    DIV,
    BLANK
}

fun compute(expression: String): Double? {
    val numberStack = Stack<Double>()
    val operatorStack = Stack<Operator>()

    var counter = 0
    while (counter < expression.length) {
        val value = parseNextNumber(expression, counter)
        numberStack.push(value.toDouble())

        counter += value.toString().length

        if (counter >= expression.length) return 0.0

        val op = parseNextOperator(expression, counter)
        collapseTop(op, numberStack, operatorStack)
        operatorStack.push(op)
        counter++
    }

    collapseTop(Operator.BLANK, numberStack, operatorStack)
    if (numberStack.size == 1 && operatorStack.size == 1) return numberStack.pop()
    return 0.0
}

fun parseNextNumber(seq: String, offset: Int): Int {
    val sb = StringBuilder()
    var offset1 = offset
    while (offset1 < seq.length && Character.isDigit(seq[offset1])) {
        sb.append(seq[offset1])
        offset1++
    }

    return Integer.parseInt(sb.toString())
}

fun parseNextOperator(seq: String, offset: Int): Operator {
    if (offset < seq.length) {
        return when (seq[offset]) {
            '+' -> Operator.ADD
            '-' -> Operator.SUB
            '*' -> Operator.MUL
            '/' -> Operator.DIV
            else -> Operator.BLANK
        }
    }

    return Operator.BLANK
}

fun applyOp(left: Double, right: Double, operator: Operator): Double {
    return when (operator) {
        Operator.ADD -> left + right
        Operator.DIV -> left / right
        Operator.MUL -> left * right
        Operator.SUB -> left - right
        else -> right
    }
}

fun priorityOfOperator(op: Operator): Int {
    return when (op) {
        Operator.ADD -> 1
        Operator.SUB -> 1
        Operator.MUL -> 2
        Operator.DIV -> 2
        else -> 0
    }
}

fun collapseTop(futureTop: Operator, numStack: Stack<Double>, opStack: Stack<Operator>) {
    while (opStack.size >= 1 && numStack.size >= 2) {
        if (priorityOfOperator(futureTop) <= priorityOfOperator(opStack.peek())) {
            val second = numStack.pop()
            val first = numStack.pop()
            val op = opStack.pop()
            val collapsed = applyOp(first, second, op)
            numStack.push(collapsed)
        } else {
            break
        }
    }
}