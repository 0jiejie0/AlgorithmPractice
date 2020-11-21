package main.problemAndSolving.leetcode_20201120;

//统计所有小于非负整数 n 的质数的数量。
//
//
//
// 示例 1：
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
//
//
// 示例 2：
//
// 输入：n = 0
//输出：0
//
//
// 示例 3：
//
// 输入：n = 1
//输出：0
//
//
//
//
// 提示：
//
//
// 0 <= n <= 5 * 106
//
// Related Topics 哈希表 数学
// 果然，暴力是不行的，大的数超时了
// 最后执行的输入：499979
// 将因数查找区间缩小到1~平方根，快了很多，但依然超时
public class T204计数质数 {
    public int countPrimes(int n) {
        if (n <= 3) {
            return n == 3 ? 1 : 0;
        }
        int res = 1;
        boolean isPrime;
        for (int i = 3; i < n; i += 2) {//前面已经排除了2，以后出现的质数一定不是偶数（2的倍数）
            isPrime = true;//下方循环找到因数时标记非质数
            for (int j = 3; j <= Math.sqrt(i); j += 2) {//因数查找范围控制在[3，i开平方)，且跳过偶数
                if ((i % j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                res++;
            }
        }
        return res;
    }
}
