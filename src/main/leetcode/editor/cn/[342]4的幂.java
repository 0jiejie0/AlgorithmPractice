package main.leetcode.editor.cn;//给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
//
// 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4ˣ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不使用循环或者递归来完成本题吗？ 
//
// Related Topics 位运算 递归 数学 👍 415 👎 0


import main.customUtil.AssertExample;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //    @AssertExample(params = "0", expectResult = "false")
//    @AssertExample(params = "1", expectResult = "true")
//    @AssertExample(params = "4", expectResult = "true")
    public boolean isPowerOfFour(int n) {
        int c = n - 1, t = c;
        c = (0x5555_5555 & c) + (0x5555_5555 & (c >> 1));
        c = (0x3333_3333 & c) + (0x3333_3333 & (c >> 2));
        c = (0x0f0f_0f0f & c) + (0x0f0f_0f0f & (c >> 4));
        c = (0x00ff_00ff & c) + (0x00ff_00ff & (c >> 8));
        c = (0x0000_ffff & c) + (0x0000_ffff & (c >> 16));
        return n > 0 && (n == 1 || (0 == (t & n) && 0 == (c & 1)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:42.1 MB,击败了5.03% 的Java用户
