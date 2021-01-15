package com.sammidev.kotlin

interface Action {
    fun action()
}

fun fireAction(action: Action) {
    action.action()
}

fun main() {
    fireAction(object : Action {
        override fun action() = println("hello")
    })

    fireAction(object : Action {
        override fun action() = println("dev")
    })


    App.hello("Sammidev")

    // destructing
    val (name,age) = Person2("sammidev", 19)
    println(name)
    println(age)
}

data class Person2 (
    val name: String,
    val age: Int
)

class App {
    companion object {
        fun hello(name: String) {
            println(name)
        }
    }
}


interface Base {
    fun sayhello(name: String)
}
class MyBase : Base {
    override fun sayhello(name : String) {
        println(name)
    }
}
