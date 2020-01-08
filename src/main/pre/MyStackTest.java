package main.pre;

import junit.framework.TestCase;

public class MyStackTest extends TestCase {
    MyStack<String> stack=new MyStack<>();
    public void setUp() throws Exception {
    }

    public void tearDown() throws Exception {
    }

    public void testPush() {
        stack.push("a");
        stack.push("b");
        stack.push("c");
    }

    public void testPop() {
        assertEquals(stack.pop(),"c");
        assertEquals(stack.peek(),"b");
        assertEquals(stack.pop(),"b");
        assertEquals(stack.pop(),"a");
    }

    public void testEmpty() {
        assertEquals(stack.empty(),true);
        testPush();
        assertEquals(stack.empty(),false);
        testPop();
        assertEquals(stack.empty(),true);
    }

    public void testGetSize() {
        assertEquals(stack.getSize(),0);
        testPush();
        assertEquals(stack.getSize(),3);
        testPop();
        assertEquals(stack.getSize(),0);
    }

    public void testPeek() {
    }
}