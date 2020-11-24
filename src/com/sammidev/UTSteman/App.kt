package com.sammidev.UTSteman

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    var a: Double
    var b: Double
    var c: Double
    var re: Double
    var x1: Double
    var x2: Double
    var im: Double
    var diskriminasi: Double

    val input = BufferedReader(InputStreamReader(System.`in`))
    print("Masukkan a : ")
    a = input.readLine().toDouble()
    print("Masukkan b : ")
    b = input.readLine().toDouble()
    print("Masukkan c : ")
    c = input.readLine().toDouble()

    diskriminasi = b.pow(2.0) - (4 * a * c)
    if (diskriminasi > 0) {
        x1 = (-b + sqrt(diskriminasi)) / ( 2 * a)
        x2 = (-b - sqrt(diskriminasi)) / ( 2 * a)
        println("Akar real = $x1, $x2")
    }else if (diskriminasi == 0.0) {
        x1 = (-b) / (2 * a)
        x2 = x1
        println("Akar kembar = $1, $2")
    }else {
        re = (-b) / (2 * a)
        x2 = sqrt(diskriminasi) / (2 * a)
        im = sqrt(abs(diskriminasi)) / (2 * a)
        println("Akar komplek \n" +
                "X1 = $re + $im\n" +
                "X2 = $re - $im")
    }
    x1 = (-b + sqrt(diskriminasi)) / (2 * a)
    im = sqrt(abs(diskriminasi)) / (2 * a)
}