package main.pre;

import junit.framework.TestCase;

public class MyQueueTest extends TestCase {
    MyQueue<String> queue=new MyQueue<>();
    public void setUp() throws Exception {
        testEnqueue();
    }

    public void tearDown() throws Exception {
    }

    public void testEnqueue() {
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
    }

    public void testDequeue() {
        assertEquals(queue.peek(),"a");
        assertEquals(queue.getSize(),4);
        assertEquals(queue.dequeue(),"a");
        assertEquals(queue.getSize(),3);
        assertEquals(queue.dequeue(),"b");
        assertEquals(queue.dequeue(),"c");
        assertEquals(queue.peek(),"d");
        assertEquals(queue.getSize(),1);
        assertEquals(queue.empty(),false);
        assertEquals(queue.dequeue(),"d");
        assertEquals(queue.empty(),true);
        assertEquals(queue.dequeue(),null);
    }

    public void testEmpty() {
    }

    public void testPeek() {
    }
}