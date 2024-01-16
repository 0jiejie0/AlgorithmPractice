package main.problemAndSolving.leetcode.leetcode_20201107;

import java.util.HashSet;

//编写一个算法来判断一个数 n 是不是快乐数。
//
// 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果 可以变为 1，那么这个数就是快乐数。
//
// 如果 n 是快乐数就返回 True ；不是，则返回 False 。
//
//
//
// 示例：
//
// 输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
//
// Related Topics 哈希表 数学
// 还行，比较简单，利用哈希set记录出现过的值，如果计算过程中有数字出现两次则该数不是快乐数，用时19m
// 执行耗时:1 ms,击败了100.00% 的Java用户
//		内存消耗:35.6 MB,击败了77.04% 的Java用户
public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int temp = n;
        while (n != 1) {
            temp = 0;
            while (n > 0) {
                temp += (n % 10) * (n % 10);
                n /= 10;
            }
            n = temp;
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
        }
        return true;
    }
}
