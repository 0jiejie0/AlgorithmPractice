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
     * 题目说是二分那就用二分试试吧，二分效率有点低，向结果逼近的速度不够快
     * 看完别人的题解，感觉是自己脑子不太灵光了，结合b=a^2-x函数图像和b'=2a的切线和a轴交点，易得a2=(a1+x/a1)/2点比a1点更为接近实根
     * (b为因变量，a为自变量)
     * 递归当然要改成递推，减少出入栈操作
     */
    public int mySqrt(int x) {
        double a = (x + 1.0) / 2;
        while ((int) a != (int) (a = (a + x / a) / 2)) ;
        return (int) a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 	执行耗时:1 ms,击败了88.60% 的Java用户
//	内存消耗:39.8 MB,击败了61.34% 的Java用户
// 感觉二分效率有点低，向结果逼近的速度不够快
// 用牛顿迭代法，时间是降下来了，但是可能是因为两个变量？耗内存并不低，不清楚是不是强转导致的，缩减变量，多次运行，取个最好结果
//	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:39.7 MB,击败了87.20% 的Java用户
