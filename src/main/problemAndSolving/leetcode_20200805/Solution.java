package main.problemAndSolving.leetcode_20200805;
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
// 示例 1:
//
// 输入: 1->1->2
//输出: 1->2
//
//
// 示例 2:
//
// 输入: 1->1->2->3->3
//输出: 1->2->3
// Related Topics 链表
//边聊天边写的，耗时：14m
//执行耗时:1 ms,击败了72.15% 的Java用户
//		内存消耗:39.3 MB,击败了70.38% 的Java用户

public class Solution {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null && p.next != null) {
            while (p.next != null && p.val == p.next.val) {
                p.next = p.next.next;
            }
            p = p.next;
        }
        return head;
    }
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
//
//
// 说明:
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
// 示例:
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
// Related Topics 数组 双指针
    //思路：从num1的m+n处向前依次存放最大值
    //耗时：22m
    //从if条件转到用条件运算符赋值，提升代码简洁度，多耗费一点时间
    //执行耗时:0 ms,击败了100.00% 的Java用户
    //		内存消耗:39.7 MB,击败了79.27% 的Java用户

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m - 1;
        int b = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if ((a | b) >= 0) {
                nums1[i] = (nums1[a] > nums2[b]) ? nums1[a--] : nums2[b--];
            } else {
                nums1[i] = (b < 0) ? nums1[a--] : nums2[b--];
            }
        }
    }

}
