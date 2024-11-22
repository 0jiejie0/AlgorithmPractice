package main.leetcode.editor.cn;

import main.customUtil.leetcode.ListNode;
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// Related Topics 递归 链表 👍 3725 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // 共有逻辑
        if (head == null || head.next == null) {
            return head;
        }
        // 递归独有
//        ListNode listNode = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return listNode;
        // 	执行耗时:0 ms,击败了100.00% 的Java用户
        //	内存消耗:41.3 MB,击败了85.68% 的Java用户
        // 递归翻转的写法竟然还不太习惯
        // 迭代独有
        ListNode p = head.next, pp;
        head.next = null;
        while (p != null) {
            pp = p.next;
            p.next = head;
            head = p;
            p = pp;
        }
        return head;
        // 执行耗时:0 ms,击败了100.00% 的Java用户
        //        内存消耗:41.6 MB,击败了10.86% 的Java用户
        // 果然还是迭代更快，但是内存占用应该更低才是？？？
    }
}
//leetcode submit region end(Prohibit modification and deletion)
