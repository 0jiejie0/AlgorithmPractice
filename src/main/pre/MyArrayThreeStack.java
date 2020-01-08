package main.pre;

public class MyArrayThreeStack<T> extends IArrayThreeLinkedList<T> implements ThreeStack<T> {
    public MyArrayThreeStack(int capacity) {
        super(capacity);
    }

    public MyArrayThreeStack() {
    }

    @Override
    public void push(int k, T element) {
        super.add(k,element);
    }

    @Override
    public T pop(int k) {
        if(k<0||k>=super.getK()) {
            return null;
        }
        int size=super.getSize(k);
        if (size==0)
            return null;
        T top=super.getElements(k,size-1);
        super.delete(k,size-1);
        return top;
    }

    @Override
    public boolean empty(int k) {
        if(k<0||k>=super.getK()) {
            return true;
        }
        return super.getSize(k)==0;
    }

    @Override
    public T peek(int k) {
        if(k<0||k>=super.getK()) {
            return null;
        }
        int size=super.getSize(k);
        if (size==0)
            return null;
        return super.getElements(k,size-1);
    }
}
