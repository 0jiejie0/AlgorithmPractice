package main.problemAndSolving.leetcode_20200818;

import java.util.HashSet;

//编写一个程序，找到两个单链表相交的起始节点。
//
// 如下面的两个链表：
//
//
//
// 在节点 c1 开始相交。
//
//
//
// 示例 1：
//
//
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//
//
//
//
// 示例 2：
//
//
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
//
//
//
//
// 示例 3：
//
//
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
//
//
//
//
// 注意：
//
//
// 如果两个链表没有交点，返回 null.
// 在返回结果后，两个链表仍须保持原有的结构。
// 可假定整个链表结构中没有循环。
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
//
// Related Topics 链表
// 用hashset比较方便，但是性能表现很不理想，用时13m
// 执行耗时:9 ms,击败了14.59% 的Java用户
//		内存消耗:43.5 MB,击败了6.59% 的Java用户
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = null, tempB = null, p, res = null;
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null && headB != null) {
            p = headA;
            headA = headB;
            headB = p;
            if (set.contains(headA)) {
                res = headA;
                break;
            }
            set.add(headA);
            //调整访问部分的链表方向
            p = headA;
            headA = headA.next;
            p.next = tempA;
            tempA = p;
        }
        if (res == null) {//没找到交点可能是较短的链表遍历完了
            ListNode head = headA == null ? headB : headA;
            ListNode temp = headA == null ? tempB : tempA;
            while (head != null) {
                if (set.contains(head)) {
                    res = head;
                    break;
                }
                p = head;
                head = head.next;
                p.next = temp;
                temp = p;
            }
        }
        if (res != null) {//找到节点后，调整相交部分
            if (res == headB) {//headB为交点，则将B一套指到到A上,将B定位到非交点，以待调整
                headB = headA;
                p = tempA;
                tempA = tempB;
                tempB = p;
            }
            while (tempB != res) {//整理从交点到链表尾的部分,调回原方向
                p = tempB;
                tempB = tempB.next;
                p.next = headB;
                headB = p;
            }
            //调整交点
            tempB = tempB.next;
            res.next = headB;
            headA = headB = res;
        }
        //调整不相交部分
        while (tempA != null) {
            p = tempA;
            tempA = tempA.next;
            p.next = headA;
            headA = p;
        }
        while (tempB != null) {
            p = tempB;
            tempB = tempB.next;
            p.next = headB;
            headB = p;
        }
        return res;
    }
}
