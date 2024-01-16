package main.problemAndSolving.leetcode.leetcode_20200728;
//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
// 示例 1:
//
// 输入: 4
//输出: 2
//
//
// 示例 2:
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842...,
//     由于返回类型是整数，小数部分将被舍去。
//
// Related Topics 数学 二分查找
//耗时6天
//执行耗时:2 ms,击败了57.09% 的Java用户 内存消耗:36.7 MB,击败了90.81% 的Java用户

public class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        } else if (x >= 2147395600) {
            return 46340;
        } else if (x <= 5) {
            return x >> 1;
        }
        int M = (x >> 1 < 46340 ? x >> 1 : 46340), m = digitShift(x);
        int diff = M - m;
        while (diff > 1) {
            if (diff > 2) {
//                if (x < ((m >> digitShift(m)) + (M >> digitShift(M))) * ((m >> digitShift(m)) + (M >> digitShift(M)))) {
//                    M = ((m >> digitShift(m)) + (M >> digitShift(M)));
//                }
//                else
                if (x < ((m >> 1) + (M >> 1) + (m & M & 1)) * ((m >> 1) + (M >> 1) + (m & M & 1))) {
                    M = ((m >> 1) + (M >> 1) + (m & M & 1));
                }
//                if (x >= ((m >> digitShift(m)) + (M >> digitShift(M))) * ((m >> digitShift(m)) + (M >> digitShift(M)))) {
//                    m = ((m >> digitShift(m)) + (M >> digitShift(M)));
//                }
//                else
                if (M * M > 0 && x >= ((m >> 1) + (M >> 1) + (m & M & 1)) * ((m >> 1) + (M >> 1) + (m & M & 1))) {
                    m = ((m >> 1) + (M >> 1) + (m & M & 1));
                }
            } else {
                while (x < (M - 1) * (M - 1)) {
                    M -= 1;
                }
                while (x >= (m + 1) * (m + 1)) {
                    m += 1;
                }
            }
            diff = M - m;
        }
        return m;
    }

    /**
     * 计算近似开根的位移位数(小于实际根)
     *
     * @param n
     * @return
     */
    private static final int digitShift(int n) {
        for (int i = 31; i > 0; i--) {
            if ((n >>> i) > 0) {
                return ((i + 1) >> 1);
            }
        }
        return 1;
    }
}
