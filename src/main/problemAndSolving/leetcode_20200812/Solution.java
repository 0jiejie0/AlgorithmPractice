package main.problemAndSolving.leetcode_20200812;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串 还算比较简单，
// 执行耗时:3 ms,击败了92.53% 的Java用户
//		内存消耗:40.1 MB,击败了23.24% 的Java用户

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
//        char[] chars = s.trim().toLowerCase().toCharArray();
//        不截空格好像好废内存少一些
//        执行耗时:3 ms,击败了92.53% 的Java用户
//		内存消耗:39.7 MB,击败了73.35% 的Java用户
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (chars[i] == chars[j]) {
                i++;
                j--;
            } else if (chars[i] < '0' || '9' < chars[i] && chars[i] < 'a' || chars[i] > 'z') {
                i++;
            } else if (chars[j] < '0' || '9' < chars[j] && chars[j] < 'a' || chars[j] > 'z') {
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
