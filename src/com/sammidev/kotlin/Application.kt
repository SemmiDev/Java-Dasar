package com.sammidev

import java.util.*
import kotlin.math.sign

class Application

fun main() {

    var sammi = Person("sammidev", 19).toStudent("2003113948");
    println(sammi)

    var sammi2 = Person("sammidev", 19).toLecture("2003113948");
    println(sammi2)

    val a = mutableListOf<Student>(sammi)
    val b = mutableListOf<Lecture>(sammi2)

    val login = Token("sammidev")
    println(login.randomUUID())

    val minmax = minmax(2,3)
    val (minimum, _) = minmax
    println(minimum)

    val req = SignIn("Sammidev", "sammidev")
    val success = signin(req) {
        (user,pass) -> user == "Sammidev" && pass == "sammidev"
    }


}

// elvis
data class Friend(val name: String)

fun sayhello(friend: Friend) {
    val name = friend?.name ?: "takde"
    println(name)
}


data class SignIn(val user :String, val pass: String)
typealias SignInCallback = (SignIn) -> Boolean

fun signin(signIn: SignIn, signInCallback: (SignIn) -> Boolean): Boolean {
    return signInCallback(signIn)
}

data class MinMax(val min: Int, val max: Int)

fun minmax(value1: Int, value2: Int): MinMax {
    return when {
        value1 < value2 -> MinMax(value1, value2)
        else -> MinMax(value2, value1)
    }
}

inline class Token(val value: String) {
    fun randomUUID() : String = UUID.randomUUID().toString() + value
}

data class Person(val name: String, val age: Int)

fun Person.toStudent(nim: String) = Student(this.name, this.age, nim)
fun Person.toLecture(nip: String) = Lecture(this.name, this.age, nip)

data class Student(
    val name: String,
    val age: Int,
    val nim: String
)
data class Lecture(
    val name: String,
    val age: Int,
    val nip: String
)