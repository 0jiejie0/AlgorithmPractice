package main.pre;

import java.util.Arrays;

public class IArrayThreeLinkedList<T> {
    private int K=3;
    private T []elements;
    private int []size=new int[K];
    private int capacity=10;

    public IArrayThreeLinkedList(int capacity) {
        this.capacity = capacity;
        elements=(T[]) new Object[K*capacity];
    }

    public IArrayThreeLinkedList() {
        elements=(T[])new Object[K*capacity];
    }

    public void add(int k,T element){
        if(k<0||k>(K-1)){
            System.out.println("none this list"+k);
            return;
        }else if(size[k]==capacity){
            System.out.println("LinkedList "+k+"full!");
            return;
        }
        elements[k*capacity+size[k]++]=element;
    }

    public void delete(int k,int index){
        if(k<0||k>(K-1)){//链表越界
            System.out.println("none this list"+k);
            return;
        }else if(size[k]==0){//链表为空
            System.out.println("LinkedList "+k+"null!");
            return;
        }else if(index<0||index>=size[k]){//下标越界
            System.out.println("index over ride!");
            return;
        }
        for (int i = index; i < size[k]-1; i++) {
            elements[k*capacity+i]=elements[k*capacity+i+1];
        }
        elements[k*capacity+--size[k]]=null;
    }

    public void update(int k,int index,T newElement){
        if(k<0||k>(K-1)){//链表越界
            System.out.println("none this list"+k);
            return;
        }else if(size[k]==0){//链表为空
            System.out.println("LinkedList "+k+"null!");
            return;
        }else if(index<0||index>=size[k]){//下标越界
            System.out.println("index over ride!");
            return;
        }
        elements[k*capacity+index]=newElement;
    }

    public T getElements(int k,int index) {
        return elements[k*capacity+index];
    }

    public int getSize(int k) {
        return size[k];
    }

    public int getK() {
        return K;
    }

    @Override
    public String toString() {
        StringBuffer []stringBuffer=new StringBuffer[K];
        for (int i = 0; i < K; i++) {
            stringBuffer[i]=new StringBuffer("linkedList"+i+"[");
            for (int j = 0; j < size[i]; j++) {
                if(j!=0)
                    stringBuffer[i].append(" , ");
                stringBuffer[i].append(elements[i*capacity+j]);
            }
            stringBuffer[i].append("]   ");
        }
        StringBuffer stringBufferAll=new StringBuffer();
        for (int i = 0; i < K; i++) {
            stringBufferAll.append("\n"+stringBuffer[i].toString());
        }
        return stringBufferAll.toString();
    }
//    public void delete(T element){}
//
//    public T at(int index){return null;}//数组链表主要用作实现一个数组分三个栈，没有必要实现链表的全部功能
//
//    public int indexof(T element){return -1;}
}