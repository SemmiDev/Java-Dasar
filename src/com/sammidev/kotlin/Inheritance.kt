package com.sammidev.kotlin

import java.math.BigDecimal

class Inheritance

open class Person(val name: String) {

    fun fullname(name: String) {
        println("hello ${this.name} with$name")
    }
}


class Manager(name: String) : Person(name)
class VicePresident(name: String,val salary: BigDecimal) : Person(name) {
    fun show() {
        println("${this.name} ${this.salary}")
    }
}

fun main() {

    val manager: Person = Manager("sam")
    manager.fullname("sammidev")

    val vicePresident = VicePresident("sam2", BigDecimal(10000))h
    vicePresident.fullname("sammidev2")
    vicePresident.show()

}