package main.problemAndSolving.leetcode_20200719;
//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
// 示例 1:
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
//
//
// 示例 2:
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
//
// Related Topics 数组
//做了很多bug，用时25m
//解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户
// 内存消耗:38.1 MB,击败了5.63% 的Java用户

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; carry == 1 && i >= 0; i--) {
            carry = ++digits[i] / 10;
            digits[i] %= 10;
        }
        //最高位进位，数组加长
        if (carry == 1) {
            int[] temp = new int[digits.length + 1];
            temp[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                temp[i + 1] = digits[i];
            }
            digits = temp;
        }
        return digits;
    }
}
