package main.problemAndSolving.leetcode_20201031;

//给定一个Excel表格中的列名称，返回其相应的列序号。
//
// 例如， 
//
//     A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// 示例 1: 
//
// 输入: "A"
//输出: 1
// 
//
// 示例 2: 
//
// 输入: "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 输入: "ZY"
//输出: 701 
//
// 致谢： 
//特别感谢 @ts 添加此问题并创建所有测试用例。 
// Related Topics 数学
// 很简单的26转10的类似进制转换的弱智题目
// 执行耗时:1 ms,击败了100.00% 的Java用户
//		内存消耗:38.5 MB,击败了9.26% 的Java用户
public class Solution {
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (char c :
                chars) {
            res = (res * 26 + (c - 'A' + 1));
        }
        return res;
    }
}
