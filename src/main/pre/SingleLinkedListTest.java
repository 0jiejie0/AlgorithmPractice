package main.pre;

import groovy.util.GroovyTestCase;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SingleLinkedListTest extends GroovyTestCase {
    SingleLinkedList<String> list =new SingleLinkedList<String>();
    public void setUp() throws Exception {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list);
    }

    public void tearDown() throws Exception {
        System.out.println(list);
    }

    public void testAdd() {
        list.add("e");
    }

    public void testDelete() {
        list.delete("d");
        list.delete("d");
        list.delete("ha");
    }

    public void testDelete1() {
        list.delete(0);
        list.delete(0);
        list.delete(0);
        list.delete(0);
        list.delete(0);
        list.delete(0);
        list.delete(0);
        list.delete(0);
        list.delete(0);
        list.delete(90);
    }

    public void testUpdate() {
        list.update(1,"world");
        list.update(99,"hello");
    }

    public void testContains() {
        System.out.println(list.contains("hello"));
        System.out.println(list.contains("c"));
    }

    public void testAt() {
        System.out.println(list.at(1));
        System.out.println(list.at(199));
    }

    public void testIndexof() {
        System.out.println(list.indexof("a"));
        System.out.println(list.indexof("d"));
        System.out.println(list.indexof("hello"));
    }
    @Test
    public void testiter(){
        while (list.hasNext()){
            System.out.println(list.next());
        }
    }
}