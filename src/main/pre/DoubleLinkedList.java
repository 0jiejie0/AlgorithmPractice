package main.pre;

public class DoubleLinkedList<T> implements MyList<T>{
    private ListNode first=new ListNode(null);
    private ListNode last=new ListNode(null);
    private int size=0;

    public DoubleLinkedList() {
        first.next=last;
        last.pre=first;
    }

    @Override
    public void add(T element) {
        ListNode node=new ListNode(element);
        last.pre.next=node;
        node.next=last;
        node.pre=last.pre;
        last.pre=node;
        size++;
    }

    @Override
    public void delete(T element) {
        ListNode p=first.next;
        while (p!=last){
            if(p.data.equals(element)){
                p.pre.next=p.next;
                p.next.pre=p.pre;
                p.pre=null;
                p.next=null;
                size--;
                return;
            }
            p=p.next;
        }
    }

    @Override
    public void delete(int index) {
        if(index<0||index>=size)
            return;
        ListNode p=first.next;
        for (int i = 0; i < size; i++) {
            if(i==index) {
                p.pre.next=p.next;
                p.next.pre=p.pre;
                p.pre=null;
                p.next=null;
                size--;
                return;
            }
            p=p.next;
        }
    }

    @Override
    public void update(int index, T newElement) {
        if(index<0||index>=size)
            return;
        ListNode p=first.next;
        for (int i = 0; i < size; i++) {
            if(index==i){
                p.data=newElement;
                return;
            }
            p=p.next;
        }
    }

    @Override
    public boolean contains(T target) {
        return indexof(target)>=0;
    }

    @Override
    public T at(int index) {
        if(index<0||index>=size)
            return null;
        ListNode p=first.next;
        for (int i = 0; i < size; i++) {
            if(i==index)
                return (T)p.data;//同单链表，p的data类型没有转换过来
            p=p.next;
        }
        return null;
    }

    @Override
    public int indexof(T element) {
        ListNode p=first.next;
        for (int i = 0; i < size; i++) {
            if (p.data.equals(element))
                return i;
            p=p.next;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer=new StringBuffer("[");
        ListNode p=first.next;
        while (p!=last){
            stringBuffer.append(p.data);
            if(p.next!=last)
                stringBuffer.append(" , ");
            p=p.next;
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public ListNode getLast() {
        return last;
    }

    public ListNode getFirst() {
        return first;
    }

    ListNode<T> now=first;
    @Override
    public boolean hasNext() {
        return now.next!=last;
    }

    @Override
    public T next() {
        ListNode<T> node=now.next;
        now=now.next;
        return node.data;
    }
}
