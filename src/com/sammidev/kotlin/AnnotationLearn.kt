package com.sammidev

class AnnotationLearn


@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Fancy(val author: String)


@Target(
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.FIELD,
    AnnotationTarget.VALUE_PARAMETER
)
annotation class Beta


@Fancy(author = "sammidev")
class MyApp(val name: String, val version: String) {
    fun info() {
        val s = (name + version).apply {
            println(this)
        }
    }
}

fun main() {
    val mahasiswa = Mahasiswa("sammidev", 11)
        .let {
            it.name = "sammi"
            it.age = 12
            println(it)
        }
    val mahasiswa2 = Mahasiswa("sammidev", 12)
        .run {
            this.name = "sammidev"
            this.age  = 10
            println(this)
        }

    val mahasiswa3 = Mahasiswa("Sammidev", 19)
        .apply {
            this.name = "sam"
            this.age = 12
            println(this)
        }
}


data class Mahasiswa (
    var name : String,
    var age : Int
)