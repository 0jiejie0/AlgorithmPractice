package main.problemAndSolving.leetcode.leetcode_20200613;
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
// 示例 1:
//
// 输入: 123
//输出: 321
//
//
// 示例 2:
//
// 输入: -123
//输出: -321
//
//
// 示例 3:
//
// 输入: 120
//输出: 21
//
//
// 注意:
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
// Related Topics 数学

public class Solution {
    public int reverse(int x) {
//        if (x == 0) {
//            return 0;
//        }
//        boolean negative = x < 0 ? true : false;//保存符号
//        if (negative) {//将负数转为正数
//            x = -x;
//        }
//        long result = 0;
//        while (x > 0) {
//            result = result * 10 + x % 10;
//            x /= 10;
//        }
//        if ((result + 1) <= (1 << 31) - 1) {
//            //绝对值在2的31次方内，一定不会溢出
//            return (int) (negative ? -result : result);
//        }
//        if (negative && result == 1 << 31) {
//            //负数时，绝对值为2的31次方，不会溢出
//            return 1 << 31;
//        }
//        //溢出
//        return 0;
//        借鉴其他人的提交记录
        if (x == 0) {
            return 0;
        }
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return (result == (int) result) ? (int) result : 0;
    }
}
