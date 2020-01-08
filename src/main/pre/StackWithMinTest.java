package main.pre;

import junit.framework.TestCase;

public class StackWithMinTest extends TestCase {
    StackWithMin stack=new StackWithMin();
    public void setUp() throws Exception {
        assertEquals(stack.getMin(),-1);
        stack.push(3);
        assertEquals(stack.getMin(),3);
        stack.push(5);
        assertEquals(stack.getMin(),3);
        stack.push(2);
        assertEquals(stack.getMin(),2);
        stack.push(99);
        assertEquals(stack.getMin(),2);
    }

    public void tearDown() throws Exception {
    }

    public void testPush() {
    }

    public void testPop() {
    }

    public void testEmpty() {
    }

    public void testPeek() {
    }

    public void testGetMin() {
    }
}