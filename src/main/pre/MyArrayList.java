package main.pre;

public class MyArrayList<T> implements MyList<T>{
    private T [] elements;//实际存储空间
    private int size=0;//内容大小
    private int capacity=10;

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        elements=(T[]) new Object[capacity];
    }

    public MyArrayList() {
        elements=(T[]) new Object[capacity];
    }

    @Override
    public void add(T element) {
        if (size == this.capacity) {
            capacity*=2;
            T[]newElements=(T[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newElements[i]=elements[i];
            }
            elements=newElements;
        }
        elements[size++]=element;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer=new StringBuffer("[");
        for (int i = 0; i < size; i++) {
            stringBuffer.append(elements[i].toString()+(i==size-1?"":" , "));
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override
    public void delete(T element) {
        int index=indexof(element);
        if(index>=0)
            this.delete(index);
    }

    @Override
    public void delete(int index) {
        if(index<0||index>=size)
            return;
        for (int i = index; i < size-2; i++)
            elements[i]=elements[i+1];
        elements[size--]=null;
    }
    //更新index位置的元素为newElement
    @Override
    public void update(int index, T newElement) {
        if(index<0||index>=size)
            return;
        elements[index]=newElement;
    }
    //当前列表中是否含有target这个元素
    @Override
    public boolean contains(T target) {
        return indexof(target)>=0;
    }

    @Override
    public T at(int index) {
        if(index>=0&&index<size)
            return elements[index];
        else
            return null;
    }

    @Override
    public int indexof(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element))
                return i;
        }
        return -1;
    }
    private int now;
    @Override
    public boolean hasNext() {
        return elements[now]!=null;
    }

    @Override
    public T next() {
        return elements[now++];
    }
}