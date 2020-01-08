package main.pre;

import junit.framework.TestCase;

import java.util.Iterator;

public class MyHashMapTest extends TestCase {
    MyHashMap map=new MyHashMap<>();

    public void testPut() {
        map.put("a",2);
        map.put("a",3);
        map.put("b",7);
        map.put("b",8);
        map.put("c",10);
//        System.out.println(map);
    }

    public void testClear() {
        testPut();
        assertEquals(map.toString(),"[(a,3),(b,8),(c,10)]");
        map.clear();
        assertEquals(map.toString(),"[]");
    }

    public void testContainsKey() {
        testPut();
        assertEquals(map.containsKey("a"),true);
        assertEquals(map.containsKey("c"),true);
        assertEquals(map.containsKey("d"),false);
    }

    public void testContainsValue() {
        testPut();
        assertEquals(map.containsValue(3),true);
        assertEquals(map.containsValue(8),true);
        assertEquals(map.containsValue(10),true);
        assertEquals(map.containsValue(2),false);
        assertEquals(map.containsValue(7),false);
        assertEquals(map.containsValue(1),false);
    }

    public void testGet() {
        testPut();
        assertEquals(3,(int)map.get("a"));
        assertEquals(10,(int)map.get("c"));
        assertEquals(null,map.get("d"));
    }

    public void testIsEmpty() {
        assertEquals(map.isEmpty(),true);
        testPut();
        assertEquals(map.isEmpty(),false);
        map.clear();
        assertEquals(map.isEmpty(),true);
    }

    public void testKeySet() {
        testPut();
        System.out.println(map.keySet());
    }
    public void testValues() {
    }

    public void testPutAll() {
    }

    public void testRemove() {
        testPut();
        assertEquals((int)map.remove("a"),3);
        assertEquals(map.remove("d"),null);
        assertEquals((int)map.remove("c"),10);
        map.remove("a");
        map.remove("d");
        map.remove("c");
        assertEquals(map.toString(),"[(b,8)]");
    }

    public void testSize() {
        assertEquals(map.size(),0);
        testPut();
        assertEquals(map.size(),3);
        testRemove();
        assertEquals(map.size(),1);
        map.clear();
        assertEquals(map.size(),0);
    }

    public void testIterator() {
        testPut();
        Iterator<MyHashMap.Node> iterator=map.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next()+",");
    }
}