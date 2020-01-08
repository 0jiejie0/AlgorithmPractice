package main.pre;

public class ListNode<T> {
    T data;
    ListNode pre=null;
    ListNode next=null;

    public ListNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode getPre() {
        return pre;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setPre(ListNode pre) {
        this.pre = pre;
    }
}
