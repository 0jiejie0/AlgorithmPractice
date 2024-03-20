package main.leetcode.editor.cn;//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 👍 3468 👎 0

import main.customUtil.leetcode.ListNode;

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        int[] cache = new int[202];
        ListNode p = list1;
        while (p != null && p.next != null) {
            cache[p.val + 100]++;
            p = p.next;
        }
        if (p != null) {
            cache[p.val + 100]++;
            p.next = list2;
        }
        p = list2;
        if (list1 == null) list1 = list2;
        while (p != null) {
            cache[p.val + 100]++;
            p = p.next;
        }
        p = list1;
        for (int i = 0; i < 202; i++) {
            while (cache[i] > 0) {
                cache[i]--;
                p.val = i - 100;
                p = p.next;
            }
        }
        return list1;
        //	执行耗时:0 ms,击败了100.00% 的Java用户
        //	内存消耗:41.5 MB,击败了26.40% 的Java用户
        // 调整为 修改节点值 法，提交结果不太稳定，效率不总更高
        //	执行耗时:0 ms,击败了100.00% 的Java用户
        //	内存消耗:41.5 MB,击败了46.61% 的Java用户
    }
}
//leetcode submit region end(Prohibit modification and deletion)
