package main.problemAndSolving.leetcode.leetcode_20230813WeekRankList;

import main.problemAndSolving.ListNode;

// 给你一个 非空 链表的头节点 head ，表示一个不含前导零的非负数整数。
//
//将链表 翻倍 后，返回头节点 head 。
//
//
//
//示例 1：
//
//
//输入：head = [1,8,9]
//输出：[3,7,8]
//解释：上图中给出的链表，表示数字 189 。返回的链表表示数字 189 * 2 = 378 。
//示例 2：
//
//
//输入：head = [9,9,9]
//输出：[1,9,9,8]
//解释：上图中给出的链表，表示数字 999 。返回的链表表示数字 999 * 2 = 1998 。
//
//
//提示：
//
//链表中节点的数目在范围 [1, 104] 内
//0 <= Node.val <= 9
//生成的输入满足：链表表示一个不含前导零的数字，除了数字 0 本身。
public class T6914翻倍以链表形式表示的数字 {
    public ListNode doubleIt(ListNode head) {
        if (head.next == null && head.val < 5) {
            head.val <<= 1;
            return head;
        }
        ListNode p = head.next, s = null;
        head.next = null;
        while (p != null) {
            s = p.next;
            p.next = head;
            head = p;
            p = s;
        }
        p = head.next;
        head.next = null;
        int tag = 0, cur;
        while (p != null) {
            cur = (head.val << 1) + tag;
            if (cur > 9) {
                cur -= 10;
                tag = 1;
            } else {
                tag = 0;
            }
            head.val = cur;
            s = p.next;
            p.next = head;
            head = p;
            p = s;
        }
        cur = (head.val << 1) + tag;
        if (cur > 9) {
            cur -= 10;
            tag = 1;
        } else {
            tag = 0;
        }
        head.val = cur;
        if (tag > 0) {
            return new ListNode(1, head);
        }
        return head;
    }
}
