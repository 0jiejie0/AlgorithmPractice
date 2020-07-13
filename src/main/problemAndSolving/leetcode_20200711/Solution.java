package main.problemAndSolving.leetcode_20200711;

//实现 strStr() 函数。
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。
//
// 示例 1:
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
//
//
// 示例 2:
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
//
//
// 说明:
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
// Related Topics 双指针 字符串
//下标检查不到位，多次翻看，建立单元测试后才终于修正
//区间内第一个字符重复验证降低了效率
//编写时反复修改循环变量，逻辑混乱
//用时：60m
//runtime:1 ms
//memory:38.2 MB

public class Solution {
    public int strStr(String haystack, String needle) {
        int start = -1, length;
        if (haystack == null || needle == null || haystack.length() < needle.length()) {//排除异常状况
            return -1;
        } else if (needle.length() == 0) {//边界
            return 0;
        }
        int end = haystack.length() - needle.length();//此时已经排除null、长度为零等异常情况
        for (int i = 0; i <= end; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {//找到可能的子串（每次needle从0号元素开始匹配）
                for (length = needle.length() - 1; length > 0 && haystack.charAt(i + length) == needle.charAt(length); length--) {
                    //从可能区间内，从后往前匹配。匹配过程中出现相异字符，匹配失败
                }
                if (length == 0) {
                    start = i;
                    break;
                }

                //上下两种方法差不多，上方比下方少匹配一次可能区间的第一个元素（下方可对此改良，个人感觉检验同长字符串是否相同两种方式差别不大）

//                for (length = 0; length < needle.length(); length++) {//从可能位置开始，匹配needle长度，全部验证完成则符合要求
//                    if (haystack.charAt(i + length) != needle.charAt(length)) {//匹配过程中出现相异字符，匹配失败
//                        break;
//                    }
//                }
//                if (length == needle.length()) {//匹配成功时length即为needle长度，否则一定小于（因为中途退出循环）
//                    start = i;
//                    break;
//                }
            }
        }
        return start;
    }
}
