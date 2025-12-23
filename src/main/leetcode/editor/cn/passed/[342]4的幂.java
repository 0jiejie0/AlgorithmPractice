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
        return (0 == (n & (n - 1))) && 1 == (n % 3);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:42.1 MB,击败了5.03% 的Java用户

// 2进制中1的位置
// 	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:42 MB,击败了12.81% 的Java用户

// 取模性质
//	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:41.8 MB,击败了34.91% 的Java用户
