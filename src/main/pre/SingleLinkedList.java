package main.pre;

public class SingleLinkedList<T> implements MyList<T>{
    private ListNode first;
    private ListNode last;
    private int size;
    @Override
    public void add(T element) {
        if(first==null){
            first=new ListNode(element);
            last=first;
        }else {
            last.next=new ListNode(element);
            last=last.next;
        }
        size++;
    }

    @Override
    public void delete(T element) {
        ListNode p=first;
        ListNode pre=null;
        while (p!=null){
            if(p.data.equals(element)){
                if(p==first){
                    first=first.next;
                }else {
                    pre.next=p.next;
                }
                size--;
                return;
            }
            pre=p;
            p=p.next;
        }
    }

    @Override
    public void delete(int index) {
        if(index<0||index>=size)
            return;
        ListNode p=first;
        ListNode pre=null;
        for (int i = 0; i < size; i++) {
            if(i==index) {
                if (index == 0) {
                    first = first.next;
                } else {
                    pre.next = p.next;
                }
                size--;
                return;
            }
            pre=p;
            p=p.next;
        }
    }

    @Override
    public void update(int index, T newElement) {
        if(index<0||index>=size)
            return;
        ListNode p=first;
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
        ListNode p=first;
        for (int i = 0; i < size; i++) {
            if(i==index)
                return (T)p.data;//??????p已经是listnode对象，listnode的data已经改为T类型，此处仍然提示为object类型
            p=p.next;
        }
        return null;
    }

    @Override
    public int indexof(T element) {
        ListNode p=first;
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
        ListNode p=first;
        while (p!=null){
            stringBuffer.append(p.data);
            if(p.next!=null)
                stringBuffer.append(" , ");
            p=p.next;
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
    private ListNode<T> now;
    private int nowsub =0;
    @Override
    public boolean hasNext() {
        if(nowsub==0)
            now=first;
        return now!=null;
    }

    @Override
    public T next() {
        ListNode<T> node=now;
        now=now.next;
        nowsub++;
        return node.data;
    }
}
