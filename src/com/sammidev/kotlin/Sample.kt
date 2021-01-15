package com.sammidev.kotlin

import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class StudentServiceImpl(val studentRepository: StudentRepository<Student, String>) : StudentService<Student, String> {

    override fun findall(): List<Student> {
        return studentRepository.findall()
    }

    override fun removebyname(name: String): Boolean {
        return studentRepository.removebyname(name)
    }

    override fun findbyname(name: String): Student? {
        return studentRepository.findbyname(name)
    }

}

interface StudentService<T, ID> {
    fun findall(): List<T>
    fun removebyname(name: ID) : Boolean
    fun findbyname(name: ID): Student?
}

class StudentRepositoryImpl : StudentRepository<Student, String> {

    private var data = mutableListOf<Student>(
            Student("sammidev","sammidev@gmail,com"),
            Student("sammidev2","sammidev@gmail,com"),
            Student("sammidev3","sammidev@gmail,com"),
            Student("sammidev4","sammidev@gmail,com")
    )

    override fun findall(): List<Student> {
        return this.data
    }

    override fun removebyname(name: String): Boolean {
        this.data.forEach {
            if (it.name == name) {
                this.data.remove(it)
                return true
            }
        }
        return false
    }

    override fun findbyname(name: String): Student? {
        this.data.forEach {
            if (it.name == name) {
                return it
            }
        }
        return null
    }

}

interface StudentRepository<T, ID> {
    fun findall(): List<T>
    fun removebyname(name: ID) : Boolean
    fun findbyname(name: ID): Student?
}

data class Student(val name: String, val email:String? = null)


fun main() {

    val  repository: StudentRepository<Student,String> = StudentRepositoryImpl()
    val  service: StudentService<Student,String> = StudentServiceImpl(repository)

    assertNotNull(service.findall())
    assertTrue(service.removebyname("sammidev"))
    assertNotNull(service.findbyname("sammidev2"))
}