package main.problemAndSolving.leetcode_20201120;

//删除链表中等于给定值 val 的所有节点。
//
// 示例:
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
//
// Related Topics 链表
// 超级简单，按理说不该出现在这里
// 执行耗时:1 ms,击败了99.69% 的Java用户
//		内存消耗:39.3 MB,击败了86.74% 的Java用户
public class T203移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode p = head, last = head;
        while (p != null) {
            if (p.val == val) {
                if (p != head) {
                    p = p.next;
                    last.next = p;
                } else {
                    head = p = p.next;
                    last.next = null;
                    last = p;
                }
            } else {
                last = p;
                p = p.next;
            }
        }
        return head;
    }
}
