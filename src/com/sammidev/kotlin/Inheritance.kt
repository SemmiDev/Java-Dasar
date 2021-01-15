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



open class Siswa(val name: String) {
    open fun hello() {
        println("hello from siswa 1")
    }
}

class Siswaa(name: String) : Siswa(name) {

    override fun hello() {
        println("hello  from siswa 2")
    }
    fun superr() {
        super.hello()
    }

}

fun main() {

    val sammi = Siswaa("Sammidev")
    sammi.hello()
    sammi.superr()



    val manager: Person = Manager("sam")
    manager.fullname("sammidev")

    val vicePresident = VicePresident("sam2", BigDecimal(10000))
    vicePresident.fullname("sammidev2")
    vicePresident.show()

}


