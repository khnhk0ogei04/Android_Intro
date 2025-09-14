package com.example.chapter2.bai15

fun main() {
    println("Nhập số lượng bộ test: ")
    val t = readln().toInt()
    for (i in 1..t) {
        val inputs = readln().split(' ')
        val n = inputs[0].toInt()
        val k = inputs[1].toInt()
        var counter = 0
        if (n < 0 || n < k) {
            println("Test $i:\nNO RESULT")
        } else {
            println("Test $i:")
            for (j in k..n) {
                if (j % 2 != 0) {
                    counter++
                    print("$j ")
                }
            }
            if (counter == 0) {
                println("NO RESULT")
            }
            println()
        }
    }
}