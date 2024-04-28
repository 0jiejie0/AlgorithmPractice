package main.problemAndSolving.leetcode_20240428WeekRankList;

//给你两个整数 n 和 x 。你需要构造一个长度为 n 的 正整数 数组 nums ，对于所有 0 <= i < n - 1 ，满足 nums[i + 1] 大于 nums[i] ，并且数组 nums 中所有元素的按位 AND 运算结果为 x 。
//
//返回 nums[n - 1] 可能的 最小 值。
//
//
//
//示例 1：
//
//输入：n = 3, x = 4
//
//输出：6
//
//解释：
//
//数组 nums 可以是 [4,5,6] ，最后一个元素为 6 。
//
//示例 2：
//
//输入：n = 2, x = 7
//
//输出：15
//
//解释：
//
//数组 nums 可以是 [7,15] ，最后一个元素为 15 。
//
//
//
//提示：
//
//1 <= n, x <= 108
public class T100282数组最后一个元素的最小值 {
    public long minEnd(int n, int x) {
        int i = 0, j = 0;
        long ans = 0;
        n--;
        while (i < 32) {
            if ((x & (1 << i)) == 0) {
                ans |= (n & (1 << j++)) > 0 ? 1L << i : 0;
            } else {
                ans |= (x & (1L << i));
            }
            i++;
        }
        i = j;
        while (j < 32) {
            ans |= (n & (1 << j++)) > 0 ? 1L << (j - i + 31) : 0;
        }
        return ans;
    }
}
