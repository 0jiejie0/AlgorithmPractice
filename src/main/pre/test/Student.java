package main.pre.test;

import org.jetbrains.annotations.NotNull;

public class Student {//implements Comparable<Student>{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

//    @Override
//    public int compareTo(@NotNull Student o) {//实现comparable接口
//        return this.age<o.age?-1:this.age==o.age?0:1;
//    }

    @Override
    public String toString() {
        return "{" +
                "'" + name + '\'' +
                ", " + age +
                '}';
    }
}
