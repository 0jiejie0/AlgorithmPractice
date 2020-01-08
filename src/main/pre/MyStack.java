package main.pre;

public class MyStack<T> extends DoubleLinkedList<T> implements IStack <T>{
    @Override
    public void push(T e) {
        super.add(e);
    }

    @Override
    public T pop() {
        if(empty())
            return null;
        ListNode<T> top=super.getLast().getPre();
        T topData=top.data;
        top.getPre().setNext(super.getLast());
        super.getLast().setPre(top.getPre());
        top.setPre(null);
        top.setNext(null);
        setSize(getSize()-1);
        return topData;
    }

    @Override
    public boolean empty() {
        return getSize()==0;
    }

    @Override
    public int getSize() {
        return super.getSize();
    }

    @Override
    public T peek() {
        if(empty())
            return null;
        ListNode<T> top=super.getLast().getPre();
        return top.getData();
    }
}
