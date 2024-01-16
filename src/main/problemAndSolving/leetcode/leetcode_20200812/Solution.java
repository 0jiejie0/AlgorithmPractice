package main.problemAndSolving.leetcode.leetcode_20200812;
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
// Related Topics 双指针 字符串
// 还算比较简单，只是做着题突然idea崩了，解题用时没法发算了
// 执行耗时:3 ms,击败了92.53% 的Java用户
//		内存消耗:40.1 MB,击败了23.24% 的Java用户

import java.util.LinkedList;
import java.util.List;

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

    //给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
//
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。
//
// 示例:
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
// Related Topics 数组
// 漏了行数为0的边界条件，用时12m
// 执行耗时:1 ms,击败了77.34% 的Java用户
//		内存消耗:37.1 MB,击败了93.23% 的Java用户
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> line = new LinkedList<>();
        List<Integer> last;
        line.add(1);
        res.add(line);
        last = line;
        for (int i = 1; i < numRows; i++) {
            line = new LinkedList<>();
            line.add(1);
            for (int j = 1; j < last.size(); j++) {
                line.add(last.get(j - 1) + last.get(j));
            }
            line.add(1);
            res.add(line);
            last = line;
        }
        return res;
    }
}
