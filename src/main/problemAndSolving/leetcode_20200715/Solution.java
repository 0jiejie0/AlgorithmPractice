package main.problemAndSolving.leetcode_20200715;
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
// 进阶:
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
// Related Topics 数组 分治算法 动态规划
//这道题目标记难度为简单，但实际上，并不简单，用时89m
//执行耗时:1 ms,击败了95.16% 的Java用户
//内存消耗:39.5 MB,击败了40.45% 的Java用户

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int sum = nums[0];
        int res = sum;
        int min = 0;//历史最小和
        for (int i = 1; i < nums.length; i++) {
            int temp = sum - min;
            //思路：利用当前和与历史最低值作差，最大差即为所求
            if (nums[i] < 0) {//sum下降前，差值大于历史最大则记录
                if (temp > res) {
                    res = temp;
                }
            }
            if (temp < 0) {//若sum低于历史最低值，则更新最低值
                min = sum;
            }
            //做完前序工作后，计算新和
            sum += nums[i];
        }
        return sum > min + res ? sum - min : res;
    }
}
