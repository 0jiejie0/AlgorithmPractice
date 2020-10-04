package main.problemAndSolving.leetcode_20201002;
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1:
//
// 输入: [3,2,3]
//输出: 3
//
// 示例 2:
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
//
// Related Topics 位运算 数组 分治算法
// 实在是不敢相信，利用HashMap和Set解决这个题，效率这么低！用时：18m
// 执行耗时:16 ms,击败了26.21% 的Java用户
//		内存消耗:43.8 MB,击败了27.29% 的Java用户

//		第一次优化，性能仍然很垃圾
//		执行耗时:16 ms,击败了26.21% 的Java用户
//		内存消耗:44.5 MB,击败了5.09% 的Java用户

// 看了官方题解，投票法果然是好，性能 效率相比之下非常出色
// 执行耗时:2 ms,击败了77.18% 的Java用户
//		内存消耗:42.1 MB,击败了58.42% 的Java用户

public class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length < 2) {
            return nums.length == 0 ? 0 : nums[0];
        }
        int count = 0, mode = nums[0];
        for (int n : nums) {
            if (count == 0) {//计数为0时，切换众数
                mode = n;
            } else if (n != mode) {//遍历到和众数不同的数，扣除1票
                count--;
            }
            if (n == mode) {//众数和当前数相同时（或计数为零时，计一票）
                count++;
            }
        }
        return mode;
    }
}
