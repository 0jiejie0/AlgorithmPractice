package main.pre;

public interface IQueue <T>{
    void enqueue(T e);
    T dequeue();
    boolean empty();
    T peek();
}
