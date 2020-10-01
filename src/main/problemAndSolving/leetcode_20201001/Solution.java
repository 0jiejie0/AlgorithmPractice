package main.problemAndSolving.leetcode_20201001;

import java.util.Stack;

//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
//
// 说明:
//
//
// 返回的下标值（index1 和 index2）不是从零开始的。
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
//
//
// 示例:
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
// Related Topics 数组 双指针 二分查找
//这个挺简单
//执行耗时:1 ms,击败了96.62% 的Java用户
//		内存消耗:38.8 MB,击败了92.59% 的Java用户
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int temp;
        while (l < r) {
            temp = numbers[l] + numbers[r];
            if (temp == target) {
                return new int[]{l + 1, r + 1};
            } else if (temp < target) {
                l++;
            } else {
                r--;
            }
        }
        return null;
    }

    //给定一个正整数，返回它在 Excel 表中相对应的列名称。
//
// 例如，
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB
//    ...
//
//
// 示例 1:
//
// 输入: 1
//输出: "A"
//
//
// 示例 2:
//
// 输入: 28
//输出: "AB"
//
//
// 示例 3:
//
// 输入: 701
//输出: "ZY"
//
// Related Topics 数学
    //明明是非常简单的一道题目，却在末尾位和进位运算上傻傻分不清，耗时37m
    //执行耗时:0 ms,击败了100.00% 的Java用户
    //		内存消耗:36.3 MB,击败了15.20% 的Java用户
    public String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        while (n > 0) {//每次进入循环，n的余数范围是1-25,0（26）,代表A-Y,Z
            n--;//余数范围：0-25，代表A-Z
            stack.push((char) ('A' + (n % 26)));//A+0=A,A+25=Z
            n /= 26;
        }
        while (stack.size() > 0) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.length() == 0 ? "A" : stringBuilder.toString();
    }
}
