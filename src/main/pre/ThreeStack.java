package main.pre;

public interface ThreeStack<T> {
    void push(int k,T element);
    T pop(int k);
    boolean empty(int k);
    T peek(int k);
}
