package main.pre;

import junit.framework.TestCase;

import java.util.Iterator;

public class MyHashSetTest extends TestCase {
    MyHashSet<String> set=new MyHashSet<>();
    public void setUp() throws Exception {
        testAdd();
    }

    public void testAdd() {
//        set.add("1");
//        set.add("2");
//        set.add("3");
//        set.add("4");
        set.add("6");
        set.add("8");
        set.add("9");
    }

    public void testRemove() {
        System.out.println(set);
        set.remove("6");
        set.remove("3");
        System.out.println(set);
    }

    public void testClear() {
        System.out.println(set);
        set.clear();
        System.out.println(set);
        set.remove("4");
        set.remove("9");
        System.out.println(set);
    }

    public void testContains() {
        System.out.println(set);
        assertEquals(set.contains("6"),true);
        assertEquals(set.contains("7"),false);
        assertEquals(set.contains("9"),true);
        assertEquals(set.contains("0"),false);
    }

    public void testIsEmpty() {
        System.out.println(set);
        assertEquals(set.isEmpty(),false);
        set.clear();
        assertEquals(set.isEmpty(),true);
        testAdd();
        assertEquals(set.isEmpty(),false);
    }

    public void testSize() {
        assertEquals(set.toString(),"[6,8,9]");
        assertEquals(set.size(),3);
        set.remove("8");
        assertEquals(set.toString(),"[6,9]");
        assertEquals(set.size(),2);
        set.add("3");
        set.add("4");
        set.add("6");
        assertEquals(set.toString(),"[3,4,6,9]");
        assertEquals(set.size(),4);
        set.clear();
        assertEquals(set.size(),0);
    }

    public void testToString() {
    }

    public void testIterator() {
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}