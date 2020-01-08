package main.pre;

public class CircleLinkedList {
    public boolean hasCircle(ListNode head){
        ListNode s=head;
        ListNode f=head;
        while (true){
            s=s.next;
            f=f.next.next;
            if(s==f)
                return true;
            if(f==null)
                System.out.println("f==null");
            if(f==null||f.next==null)
                return false;
        }
    }
    public ListNode circleStart(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        ListNode start=head;
        while (true){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast||fast==null||fast.next==null)
                break;
        }
        if(fast==null||fast.next==null)
            return null;
        while (start!=slow){
            start=start.next;
            slow=slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode link=new ListNode("a");
        link.next=new ListNode("b");
        link.next.next=new ListNode("c");
        link.next.next.next=new ListNode("d");
        link.next.next.next.next=new ListNode("f");
        link.next.next.next.next.next=link.next.next;
        CircleLinkedList obj=new CircleLinkedList();
        System.out.println(obj.hasCircle(link));
        System.out.println(obj.circleStart(link).data);
        link.next.next.next.next.next=new ListNode("e");
        System.out.println(obj.hasCircle(link));
    }
}
