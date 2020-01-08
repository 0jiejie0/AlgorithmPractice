package main.pre;

import junit.framework.TestCase;
import org.junit.After;

public class IArrayThreeLinkedListTest extends TestCase {
    IArrayThreeLinkedList<String> list=new IArrayThreeLinkedList(4);
    public void setUp() throws Exception {
        testAdd();
    }

    public void testAdd() {
        list.add(0,"a");
        list.add(0,"b");
        list.add(0,"c");
        list.add(0,"d");
//        list.add(0,"e");

        list.add(2,"aa");
        list.add(2,"bb");
    }

    public void testDelete() {
//        list.delete(0,4);
        list.delete(0,0);
        list.delete(0,0);
        list.delete(0,0);
        list.delete(0,0);
//        list.delete(0,0);
//        list.delete(1,0);
        list.delete(2,0);
    }

    public void testUpdate() {
//        list.update(0,4,"x");
        list.update(0,3,"hello");
        list.update(0,1,"world");
//        list.update(1,0,"hello");
        list.update(2,0,"hello");
        list.update(2,1,"world");
    }
@After
    public void tearDown() throws Exception {
        System.out.println(list.toString());
    }
}