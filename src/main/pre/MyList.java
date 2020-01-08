package main.pre;/*
线性表接口定义
 */

import java.util.Iterator;

interface MyList<T> extends Iterator<T> {
    void add(T element);
    void delete(T element);
    void delete(int index);
    void update(int index,T newElement);
    T at(int index);
    int indexof(T element);
    boolean contains(T target);
}