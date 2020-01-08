package main.pre;

import main.pre.test.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListAPIDemo {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        list=new LinkedList<String>();
        list.add("hello");
        list.add("world");
        list.add("!!!!");
        ((LinkedList<String>) list).remove("ha");
        System.out.println(list);

//        List<Student> list1=new ArrayList<>();
//        list1.add(new Student("tom",9));
//        list1.add(new Student("jerry",3));
//        list1.add(new Student("amy",8));
//        list1.add(new Student("black",12));
//        Collections.sort(list1);
//        System.out.println(list1);
        List<Student> list2=new ArrayList<>();
        list2.add(new Student("tom",97));
        list2.add(new Student("jerry",43));
        list2.add(new Student("black",12));
        list2.add(new Student("amy",84));
        Collections.sort(list2,(o1, o2) -> {
            return o1.getAge()-o2.getAge();
        });//comparator比较器
        System.out.println(list2);
    }
}
