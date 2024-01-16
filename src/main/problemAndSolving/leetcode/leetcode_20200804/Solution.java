package main.problemAndSolving.leetcode.leetcode_20200804;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划
//这道见过很多面的题目，竟然花了13分钟才解决
//执行耗时:0 ms,击败了100.00% 的Java用户
//		内存消耗:36.4 MB,击败了59.84% 的Java用户

public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int last = 1;
        int res = 2;
        int temp;
        for (int i = 2; i < n; i++) {
            temp = last + res;
            last = res;
            res = temp;
        }
        return res;
    }
}
