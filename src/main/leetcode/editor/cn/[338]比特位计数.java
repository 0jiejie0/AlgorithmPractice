//给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。 
//
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：n = 2
//输出：[0,1,1]
//解释：
//0 --> 0
//1 --> 1
//2 --> 10
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：[0,1,1,2,1,2]
//解释：
//0 --> 0
//1 --> 1
//2 --> 10
//3 --> 11
//4 --> 100
//5 --> 101
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？ 
// 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ） 
// 
//
// Related Topics 位运算 动态规划 👍 1416 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (1 == (i & 1)) {
                ans[i] = 1 + ans[i - 1];
            } else {
                ans[i] = 1 + ans[i & (i - 1)];
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//	执行耗时:4 ms,击败了16.77% 的Java用户
//	内存消耗:47.8 MB,击败了28.85% 的Java用户
// 明明应该符合要求了，为什么排名这么低，骇人听闻啊

// 原来还有动态规划的写法
// 最高有效位
//	    执行耗时:1 ms,击败了99.51% 的Java用户
//      内存消耗:48 MB,击败了5.90% 的Java用户
// 最低有效位，受最高位启发独立完成
// 	执行耗时:1 ms,击败了99.51% 的Java用户
//	内存消耗:48 MB,击败了6.79% 的Java用户

