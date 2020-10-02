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

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length < 2) {
            return nums.length == 0 ? 0 : nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        for (int n :
                nums) {
            if (!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                temp = map.get(n) + 1;
                //这里的结果是唯一的，因为同时只可能有一个数的数量，超过总数的一半
                //所以在计算过程中清点数目，省去转换Set时间
                if ((temp << 1) > nums.length) {
                    return n;
                }
                map.put(n, temp);
            }
        }
        return 0;
    }
}
