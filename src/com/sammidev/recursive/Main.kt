package com.sammidev.recursive

var count: Int = 0
fun sample1() {
    count++
    if (count <= 5) {
        println(count)
        sample1()
    }
}
fun sample2(value: Int): Int {
    if (value == 0) {
        return 1
    }
    return value * sample2(value - 1)
}

var n1: Int = 0
var n2: Int = 1
var n3: Int = 0

fun printFibo(count: Int) {
    if (count > 0) {
        /**
        ~ n3 = 1
          n1 = 1
          n2 = 1

        ~ n3 = 2
          n1 = 1
          n2 = 2

        ~ n3 = 3
          n1 = 2
          n2 = 3

        ~ n3 = 5
        */

        n3 = n1 + n2
        n1 = n2
        n2 = n3
        print(" $n3")
        printFibo(count - 1)
    }
}
fun FPB(a: Int, b: Int): Int {
    return if (b == 0){ a
    }else {
        FPB(b, a % b)
    }
}

fun main() {
    sample1() // 1 2 3 4 5
    println(sample2(5)) // 120
    printFibo(10) // 1 2 3 5 8 13 21 34 55 89
    println("\n\n")
    println(FPB(27,210))


}