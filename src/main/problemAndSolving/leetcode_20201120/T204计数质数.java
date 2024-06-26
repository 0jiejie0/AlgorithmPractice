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

// 扩展查找因数时跳过偶数的思路，在查找因数时跳过所有的合数，总算没再超时
// 执行耗时:494 ms,击败了10.92% 的Java用户
//		内存消耗:46 MB,击败了5.03% 的Java用户

// 厄拉多塞筛法 虽然比跳合数的效率高几倍，但依然不够快
// 执行耗时:83 ms,击败了16.16% 的Java用户
//		内存消耗:35.6 MB,击败了88.56% 的Java用户
//		执行耗时:75 ms,击败了16.45% 的Java用户
//		内存消耗:35.6 MB,击败了89.21% 的Java用户

// 果然是筛法代码有问题，简化代码效率提升了一倍
// 执行耗时:48 ms,击败了20.41% 的Java用户
//		内存消耗:35.3 MB,击败了95.39% 的Java用户
// 执行耗时:48 ms,击败了20.41% 的Java用户
//		内存消耗:35.9 MB,击败了84.28% 的Java用户

public class T204计数质数 {
    public int countPrimes(int n) {
        if (n <= 3) {
            return n == 3 ? 1 : 0;
        }
        byte[] counts = new byte[n / 8 + 1];//这里申请的空间位数至少为n+1位，有空余，所以舍弃第一位，下标即数字，减少差一的运算量
        int res = 0;
        for (int i = 2; i < n; i++) {
            if ((counts[i / 8] & (1 << (i & 7))) == 0) {
                res++;
                for (int j = i << 1; j < n; j += i) {//此处用移位代替乘法操作似乎并不快
                    counts[j / 8] |= (1 << (j & 7));
                }
            }
        }
        return res;
    }
}
