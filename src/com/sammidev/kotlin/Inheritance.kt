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



open class Mahasiswa(val name: String, val age: Int, val uktLevel: Int) {
    constructor(name: String,age: Int) : this(name,age,1)
    constructor(age: Int, uktLevel: Int) : this("", age,uktLevel)

    fun hello() {
        println("${this.name} ${this.age} ${this.uktLevel}")
    }
}

class Sammidev : Mahasiswa {
    constructor() : super("sammidev",12,2)
    constructor(name: String) : super(name,12,2)
    constructor(age: Int, uktLevel: Int) : super("", age, uktLevel)

    fun show() {
        println(super.name + super.age + super.uktLevel)
    }
}

fun main() {

    val sam = Sammidev(2,10)
    sam.show()


    val sammi = Siswaa("Sammidev")
    sammi.hello()
    sammi.superr()

    val manager: Person = Manager("sam")
    manager.fullname("sammidev")

    val vicePresident = VicePresident("sam2", BigDecimal(10000))
    vicePresident.fullname("sammidev2")
    vicePresident.show()

}


