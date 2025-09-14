package com.example.chapter2.bai15

fun main(){
    println("Enter number of test: ")
    val t = readln().toInt()
    for (i in 1..t) {
        var sum: Long = 0
        val n = readln().toInt()
        if (n <= 0) {
            println("Test $i:\nINVALID")
        } else {
            for (j in 1..n){
                sum += j.toLong()
            }
            println("Test $i:\n$sum")
        }
    }
}