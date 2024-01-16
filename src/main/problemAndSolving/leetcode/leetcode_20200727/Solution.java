package main.problemAndSolving.leetcode.leetcode_20200727;
//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。
//
//
//
// 示例 1:
//
// 输入: a = "11", b = "1"
//输出: "100"
//
// 示例 2:
//
// 输入: a = "1010", b = "1011"
//输出: "10101"
//
//
//
// 提示：
//
//
// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4
// 字符串如果不是 "0" ，就都不含前导零。
//
// Related Topics 数学 字符串
//简单题目，但还是尝试n次，才通过。耗时：65m
//执行耗时:3 ms,击败了59.82% 的Java用户
//		内存消耗:39.8 MB,击败了7.69% 的Java用户

public class Solution {
    public String addBinary(String a, String b) {
        StringBuffer res = new StringBuffer();
        a = new StringBuffer(a).reverse().toString();
        b = new StringBuffer(b).reverse().toString();
        int length = a.length() < b.length() ? a.length() : b.length();
        int temp = 0;
        for (int i = 0; i < length; i++) {
            temp += (a.charAt(i) == '0' ? 0 : 1) + (b.charAt(i) == '0' ? 0 : 1);
            res.append(temp & 1);
            temp >>= 1;
        }
        a = a.length() > b.length() ? a : b;
        for (int i = length; i < a.length(); i++) {
            temp += (a.charAt(i) == '0' ? 0 : 1);
            res.append(temp & 1);
            temp >>= 1;
        }
//        res.append(a.subSequence(length, a.length()));
        res.append(temp == 1 ? 1 : "");
        res = res.reverse();
        return res.toString();
    }
}
