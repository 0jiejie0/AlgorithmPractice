package main.pre;

import java.util.Stack;

public class QueueByTwoStack {
    Stack<Integer> stacka=new Stack<>();
    Stack<Integer> stackb=new Stack<>();
    public void enqueue(int node){
        if(stacka.empty())
            move(stackb,stacka);
        stacka.push(node);
    }
    public int dequeue(){
        if(!stacka.empty())
            move(stacka,stackb);
        return stackb.pop();
    }
    void move(Stack source,Stack target){
        while (!source.empty())
            target.push(source.pop());
    }

    public static void main(String[] args) {
        QueueByTwoStack queue=new QueueByTwoStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        queue.enqueue(5);
        System.out.println(queue.dequeue());
    }
}
