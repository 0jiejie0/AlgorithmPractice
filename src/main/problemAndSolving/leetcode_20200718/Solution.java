package main.problemAndSolving.leetcode_20200718;
//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
//
// 如果不存在最后一个单词，请返回 0 。
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
//
//
//
// 示例:
//
// 输入: "Hello World"
//输出: 5
//
// Related Topics 字符串
//从看到题目，到优化完成并通过验证，用时18m
//22:29	info 利用API
//		解答成功:
//		执行耗时:1 ms,击败了40.31% 的Java用户
//		内存消耗:38.1 MB,击败了6.38% 的Java用户
//
//22:40	info 优化
//		解答成功:
//		执行耗时:0 ms,击败了100.00% 的Java用户
//		内存消耗:37.8 MB,击败了6.38% 的Java用户

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        //如果利用javaAPI的话，可以很方便地解决这个问题
//        String[] strings = s.split(" ");
//        if (strings.length == 0) {
//            return 0;
//        }
//        return strings[strings.length - 1].length();
        //试一下不用API
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (len != 0)
                    break;
                continue;
            }
            len++;
        }
        return len;
    }
}
