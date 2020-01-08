package main.pre;

public class StackWithMin extends DoubleLinkedList<Integer> implements IStack <Integer> {
    private MyStack<Integer> stackMin=new MyStack<>();
    @Override
    public void push(Integer e) {
        super.add(e);
        if (stackMin.peek()==null){
            stackMin.push(e);
        }else {
            int min=stackMin.peek();
            if (e<min)
                stackMin.push(e);
        }
    }
//        if(stackMin.peek()==null)
//            stackMin.push(e);
//        else
//            stackMin.push(e<stackMin.peek()?e:stackMin.peek());//浪费空间
//    }

    @Override
    public Integer pop() {
        if(empty())
            return -1;
        ListNode<Integer> top=super.getLast().getPre();
        Integer topData=top.data;
        top.getPre().setNext(super.getLast());
        super.getLast().setPre(top.getPre());
        top.setPre(null);
        top.setNext(null);
        setSize(getSize()-1);
        if(stackMin.peek()==topData)
            stackMin.pop();
        return topData;
    }

    @Override
    public boolean empty() {
        return getSize()==0;
    }

    @Override
    public int getSize() {
        return super.getSize();
    }

    @Override
    public Integer peek() {
        if(empty())
            return null;
        ListNode<Integer> top=super.getLast().getPre();
        return top.getData();
    }

    public int getMin(){
        return empty()?-1:stackMin.peek();
    }
}
