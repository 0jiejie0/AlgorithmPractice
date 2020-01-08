package main.pre;

import junit.framework.TestCase;

public class MyArrayThreeStackTest extends TestCase {
    MyArrayThreeStack<String> stack=new MyArrayThreeStack<>(5);
    public void setUp() throws Exception {
        testPush();
    }

    public void tearDown() throws Exception {
    }

    public void testPush() {
        stack.push(0,"a");
        stack.push(0,"b");
        stack.push(0,"c");
        stack.push(0,"d");
        stack.push(0,"e");
//        stack.push(0,"f");
    }

    public void testPop() {
        assertEquals(stack.empty(0),false);
        assertEquals(stack.empty(2),true);
        assertEquals(stack.empty(4),true);
        assertEquals(stack.empty(1),true);
        assertEquals(stack.peek(0),"e");
        assertEquals(stack.pop(0),"e");
        assertEquals(stack.pop(0),"d");
        assertEquals(stack.pop(0),"c");
        assertEquals(stack.pop(0),"b");
        assertEquals(stack.peek(0),"a");
        assertEquals(stack.pop(0),"a");
        assertEquals(stack.peek(0),null);
        assertEquals(stack.pop(0),null);
        assertEquals(stack.pop(1),null);
        assertEquals(stack.empty(2),true);
        assertEquals(stack.empty(0),true);
        assertEquals(stack.peek(1),null);
        assertEquals(stack.peek(2),null);
        assertEquals(stack.peek(3),null);
        assertEquals(stack.peek(4),null);
        assertEquals(stack.pop(4),null);
        assertEquals(stack.pop(2),null);
    }

    public void testEmpty() {
    }

    public void testPeek() {
    }
}