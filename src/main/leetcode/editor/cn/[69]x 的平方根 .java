package main.leetcode.editor.cn;//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 1523 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 印象当中曾经在什么地方看到过平方根的解法，是用的递归，然而具体算法想不起来了
     * 题目说是二分那就用二分试试吧
     */
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int l = 0, h = x;
        long c;
        while (l < h) {
            if (((c = (l + (h - l) >> 1)) * c > Integer.MAX_VALUE) || c * c > x) {
                h = (int) c;
            } else if (c * c < x) {
                l = (int) c + 1;
            } else if (c * c == x) {
                return (int) c;
            }
        }
        return l - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 	执行耗时:1 ms,击败了88.60% 的Java用户
//	内存消耗:39.8 MB,击败了61.34% 的Java用户
// 感觉二分效率有点低，向结果逼近的速度不够快