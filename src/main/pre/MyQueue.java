package main.pre;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

public class MyQueue<T> extends DoubleLinkedList<T> implements IQueue<T> {
    @Override
    public void enqueue(T e) {
        super.add(e);
    }

    @Override
    public T dequeue() {
        if(empty())
            return null;
        ListNode<T> top=super.getFirst().getNext();
        T topData=top.getData();
        super.getFirst().setNext(top.next);
        top.getNext().setPre(super.getFirst());
        top.setPre(null);
        top.setNext(null);
        super.setSize(super.getSize()-1);
        return topData;
    }

    @Override
    public boolean empty() {
        return getSize()==0;
    }

    @Override
    public T peek() {
        ListNode<T> top=super.getFirst().getNext();
        T topData=top.getData();
        return topData;
    }
}
