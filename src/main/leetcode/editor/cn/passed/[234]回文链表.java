package main.leetcode.editor.cn;//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。

import main.customUtil.leetcode.ListNode;
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1982 👎 0


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
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        if (head == null || head.next == null) {
            return true;
        }
        ListNode o = p, s, t;
        s = t = null;
        while (o != null && o.next != null) {
            o = o.next.next;
            t = p;
            p = p.next;
            t.next = s;
            s = t;
        }
        if (o != null) {
            p = p.next;
        }
        while (s != null) {
            if (s.val != p.val) {
                return false;
            }
            s = s.next;
            p = p.next;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 	执行耗时:3 ms,击败了99.78% 的Java用户
//	内存消耗:67.5 MB,击败了10.77% 的Java用户
// 这个leetcode的内存统计有问题啊，这能有多少空间占用？
