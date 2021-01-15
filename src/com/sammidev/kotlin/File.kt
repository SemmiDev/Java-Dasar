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

}