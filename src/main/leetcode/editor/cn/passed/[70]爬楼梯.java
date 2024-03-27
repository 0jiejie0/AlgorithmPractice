package main.leetcode.editor.cn;//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 3478 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 动规不动规的不大明白，递推可以解开这道题，数列而已
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n < 4) return n;
        int la = 3, lb = 5, m = 4;
        while (m < n) {
            lb = la + (la = lb);
            m++;
        }
        return lb;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:39.2 MB,击败了86.19% 的Java用户