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

//负优化了，这一搞更废
// 执行耗时:13 ms,击败了7.05% 的Java用户
//		内存消耗:42.3 MB,击败了7.81% 的Java用户
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA, tempB = headB, p, res = null;
        HashSet<ListNode> set = new HashSet<>();
        while (null != tempA && null != tempB) {//两个链表同步加入结点到set，同时探测是否出现过改点
            p = tempA;//交替进行
            tempA = tempB;
            tempB = p;
            if (set.contains(tempA)) {
                return tempA;//在任一个链表遍历完一遍前找到，立即退出
            }
            set.add(tempA);//遍历时将每个结点放入hashSet中
            tempA = tempA.next;
        }
        //遍历完一个链表仍然没有找到
        tempA = tempA == null ? tempB : tempA;
        while (tempA != null) {
            if (set.contains(tempA)) {
                return tempA;
            }
            //此时若相交，则相交点一定在set中，不必再添加
            tempA = tempA.next;
        }
        return null;
    }
}
