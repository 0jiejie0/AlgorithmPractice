package main.pre;

import java.util.ArrayList;
import java.util.Stack;

public class PalindromeLinkedList {
    public boolean isPlindrome(ListNode phead){
        if(phead==null)
            return false;
        if(phead.next==null)
            return true;
        ListNode slow=phead;
        ListNode fast=phead;
        boolean isOdd=true;
        Stack<ListNode> stack=new Stack<>();
        while (fast!=null&&fast.next!=null){
            stack.push(slow);
            slow=slow.next;
            fast=fast.next.next;
            if (fast==null)
                isOdd=false;
        }
        if(isOdd)
            slow=slow.next;
        while (slow!=null){
            if(stack.pop().data!=slow.data)
                return false;
            else
                slow=slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList arrayList=new ArrayList();
        ListNode listNode;
        listNode = new ListNode(2);
        listNode.next=new ListNode(2);
//        listNode.next.next=new main.pre.ListNode(2);
        PalindromeLinkedList obj=new PalindromeLinkedList();
        System.out.println(obj.isPlindrome(listNode));
    }
}
