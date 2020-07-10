package main.problemAndSolving.leetcode_20200709;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表
//加单元测试用了一个多小时，第一次报空指针异常，两次通过
// runtime:1 ms
//memory:39.3 MB

public class Solution {
    /**
     * 解题思路：将两个链表中的结点逐个比较拆解，去小者，加到head尾部
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();//首结点为空内容，作为辅助节点便于后续处理
        ListNode tail = head;//尾结点
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;//将结点值小者加到末尾
                l1 = l1.next;//对应链表头指针后移
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
            tail.next = null;//断开连接，防止产生bug
        }
        tail.next = l1 != null ? l1 : l2;//循环结束时必有一个链表不为空,加到末尾
        return head.next;//去掉头部辅助节点
    }
}
