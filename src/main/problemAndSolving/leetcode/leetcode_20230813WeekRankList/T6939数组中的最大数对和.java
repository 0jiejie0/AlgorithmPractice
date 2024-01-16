package main.problemAndSolving.leetcode.leetcode_20230813WeekRankList;

import java.util.Arrays;

// 给你一个下标从 0 开始的整数数组 nums 。请你从 nums 中找出和 最大 的一对数，且这两个数数位上最大的数字相等。
//
//返回最大和，如果不存在满足题意的数字对，返回 -1 。
//
//
//
//示例 1：
//
//输入：nums = [51,71,17,24,42]
//输出：88
//解释：
//i = 1 和 j = 2 ，nums[i] 和 nums[j] 数位上最大的数字相等，且这一对的总和 71 + 17 = 88 。
//i = 3 和 j = 4 ，nums[i] 和 nums[j] 数位上最大的数字相等，且这一对的总和 24 + 42 = 66 。
//可以证明不存在其他数对满足数位上最大的数字相等，所以答案是 88 。
//示例 2：
//
//输入：nums = [1,2,3,4]
//输出：-1
//解释：不存在数对满足数位上最大的数字相等。
//
//
//提示：
//
//2 <= nums.length <= 100
//1 <= nums[i] <= 104
public class T6939数组中的最大数对和 {
    public int maxSum(int[] nums) {
        int ans = -1;
        int[][] cache = new int[10001][2];
        int[] tag = new int[10];
        Arrays.sort(nums);
        for (int n : nums) {
            int temp = n;
            int maxBit = 0;
            while (temp > 0) {
                maxBit = Math.max(maxBit, temp % 10);
                temp /= 10;
            }
            cache[n][0]++;
            cache[n][1] = maxBit;
            if (cache[n][0] > 1) {
                ans = Math.max(ans, n << 1);
            } else if (tag[maxBit] > 0) {
                ans = Math.max(ans, n + tag[maxBit]);
            }
            tag[maxBit] = n;
        }
        return ans;
    }
}
