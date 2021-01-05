package com.sammidev.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Student {
    private Long id;
    private String name;
    private String nim;

    public Student(Long id){
        this.id = id;
    }
    public Student(Long id, String name, String nim) {
        this.id = id;
        this.name = name;
        this.nim = nim;
    }

    public Student name(String name) {
        this.name = name;
        return this;
    }

    public Student nim(String nim) {
        this.nim = nim;
        return this;
    }

    public Student build() {
        return new Student(id,name,nim);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nim='" + nim + '\'' +
                '}';
    }
}
class StudentService {
    static List<Student> studentList = new ArrayList<Student>();
    static {
            var student = new Student(1L)
                    .name("sam")
                    .nim("200")
                    .build();
            var student2 = new Student(2L)
                    .name("sam2")
                    .nim("201")
                    .build();
        studentList.addAll(List.of(student, student2));
    }

    public Student findStudentByID(Long id) {
        for (Student student1 :studentList) {
            if (student1.getId() == id) {
                return student1;
            }
        }
        return null;
    }
}

public class App {
    public static void main(String[] args) {
        var student = new Student(1L)
                .name("sammidev")
                .nim("200311xxx")
                .build();

        // null check
        var name = Optional.ofNullable(student.getName())
                .orElse("default");

        // if logic
        var student2 = Optional.ofNullable(new StudentService().findStudentByID(1L))
                .orElseGet(() -> new Student(5L)
                .nim("")
                .name("")
                .build());

        // operation to nullable value
        String nama = Optional.ofNullable(new StudentService().findStudentByID(1L).getName())
                .map(String::toUpperCase)
                .orElse("NOT FOUND").toUpperCase();

        // nested if checked
        String nim = Optional.ofNullable(
                new StudentService().findStudentByID(1L))
                .map(Student::getNim)
                .orElse("XXXX");

        // check and throw exception
        String namewiththrow = Optional.ofNullable(
                new StudentService().findStudentByID(1L).getName())
                .orElseThrow(() -> new IllegalArgumentException("name is null"));

        // check and do something
        Optional.ofNullable(new StudentService().findStudentByID(1L))
                .map(Student::getNim)
                .ifPresent(System.out::println);

        // nested object
        char[] nimperarr = Optional.ofNullable(
                new StudentService().findStudentByID(1L))
                .map(Student::getNim)
                .map(String::toCharArray)
                .orElse(null);
        Long length = Optional.of(
                new StudentService().findStudentByID(1L))
                .map(Student::getName)
                .map(i -> i.length())
                .map(j -> j  * 100L)
                .orElse(0L);
        System.out.println(length);
    }
}
