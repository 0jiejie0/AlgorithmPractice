package main.pre;

interface IStack <T>{
    void push(T e);
    T pop();
    boolean empty();
    int getSize();
    T peek();
}