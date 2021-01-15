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

    /*val sam = Sammidev(2,10)
    sam.show()


    val sammi = Siswaa("Sammidev")
    sammi.hello()
    sammi.superr()

    val manager: Person = Manager("sam")
    manager.fullname("sammidev")

    val vicePresident = VicePresident("sam2", BigDecimal(10000))
    vicePresident.fullname("sammidev2")
    vicePresident.show()
*/

    isis()


    println(product1)
    println(product2)


    InheritFromSealed().plus(2,3)
    InheritFromSealed().minus(2,3)
    InheritFromSealed().multiply(2,3)
}


fun isis() {
    val name : Any = true
    println(name is String)
    println(name !is String)

    when(name) {
        is String -> println("this is a string")
        is Boolean -> println("this is a boolean")
        is Int -> println("this is a int")
        is Double -> println("this is a double")
    }

    val name2: Any = true
    println(name.hashCode() == name2.hashCode())



    Sign("sammidev","Sammidev").login("Sammidev", "sammi")
    Sign("sammidev","Sammidev").logout()



    val a = lateinitdemo()
    a.initdung("sammidev")
    println(a.name)


    val b = Sam()
    b.fast("sammidev")
    b.slow("sammidev")
    b.concrete()

}


abstract class LoginFlow {
    abstract val username : String
    abstract val password : String

    abstract fun login(username: String, password: String)
    abstract fun logout()
}

class Sign(
        override val username: String,
        override val password: String) : LoginFlow() {

    override fun login(username: String, password: String) {
        println("login")
    }

    override fun logout() {
        println("logout")
    }
}




class lateinitdemo {
    lateinit var name: String

    fun initdung(name: String) {
        this.name = name
    }
}







interface Interaction {
    fun concrete() {
        println("concrete")
    }

    fun fast(name: String)
    fun slow(name: String)
}

class Sam : Interaction {

    override fun fast(name: String) {
        println(name)
    }

    override fun slow(name: String) {
        println(name)
    }

}


interface A {
    fun move() {
        println("move a")
    }
}

interface B {
    fun move() {
        println("move a")
    }
}

class AB : A,B {

    override fun move() {
        super<A>.move()
        super<B>.move()
    }
}




data class Product(val name: String, val price: BigDecimal)
val product1 = Product("mousepad", BigDecimal(20000))
val product2 = product1.copy(price = BigDecimal(3000))




sealed class Operation {
    fun plus(a: Int,b:Int) { println(a+b)}
    fun minus(a: Int,b:Int) { println(a-b)}
    fun multiply(a: Int,b:Int) { println(a*b)}
}

class InheritFromSealed : Operation()


sealed class Calculate(val name: String)
class Penjumlahan : Calculate("Penjumlahan")
class Pengurangan : Calculate("Pengurangan")
class Perkalian : Calculate("Perkalian")


fun operation(value1: Int, value2: Int, calculate: Calculate) : Int{
    return when(calculate) {
        is Penjumlahan -> value1 + value2
        is Pengurangan -> value1 - value2
        else -> 0
    }
}


