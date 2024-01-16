package main.problemAndSolving.leetcode.leetcode_20200707;
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串
//第一次没有预防越界导致提交后数组越界报错，用时大概是30m
//执行耗时:1 ms,击败了82.23% 的Java用户
//内存消耗:37.8 MB,击败了20.84% 的Java用户

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs.length == 0 ? "" : strs[0];//第一个单词为默认前缀
        for (int i = 1; i < strs.length && prefix.length() > 0; i++) {//词典遍历完或前缀为空无公共前缀时退出
            if (strs[i].length() < prefix.length()) {//前缀不会长于单词
                prefix = prefix.substring(0, strs[i].length());
            }
            for (int j = 0; j < prefix.length(); j++) {//最长匹配长度为前缀长度
                if (strs[i].charAt(j) != prefix.charAt(j)) {//遇到当前单词第一个不匹配字符，切掉后续部分，停止对此单词匹配
                    prefix = prefix.substring(0, j);
                    break;
                }
            }
        }
        return prefix;
    }
}
