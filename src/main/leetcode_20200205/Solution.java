package main.leetcode_20200205;

// 477 汉明距离总和
// 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
//
// 计算一个数组中，任意两个数之间汉明距离的总和。
//
// 示例:
//
//
//输入: 4, 14, 2
//
//输出: 6
//
//解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
//所以答案为：
//HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 +
//2 + 2 = 6.
//
//
// 注意:
//
//
// 数组中元素的范围为从 0到 10^9。
// 数组的长度不超过 10^4。
//
// Related Topics 位运算
public class Solution {
    public int totalHammingDistance(int[] nums) {
//        10 ms
        int res = 0;
        int one = 0;
        int n = nums.length;
        for (int j = 0; j < 30; j++) {
            for (int i = 0; i < n; i++) {
                one += nums[i] & 1;
                nums[i] >>= 1;
            }
            res += ((n - one) * one);
            one = 0;
        }
//        11 ms
//        int res = 0;
//        int[] ones = new int[30];
//        int n = nums.length;
//        for (int num : nums) {
//            for (int i = 0; num > 0; i++) {
//                ones[i] += (num & 1);
//                num >>= 1;
//            }
//        }
//        for (int one : ones) {
//            res += (n - one) * one;
//        }
        return res;
    }
}
