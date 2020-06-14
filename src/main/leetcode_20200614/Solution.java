package main.leetcode_20200614;
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
// 示例 1:
//
// 输入: 121
//输出: true
//
//
// 示例 2:
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
//
// 示例 3:
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
//
//
// 进阶:
//
// 你能不将整数转为字符串来解决这个问题吗？
// Related Topics 数学

//从看题目到优化并修复bug完成用时：49m

public class Solution {
    public boolean isPalindrome(int x) {
        //    思路一：根据题目限制，将数字翻转，再比较
        //    思路二：在数字翻转过程中比较，节约一半时间
        int y = x;
        if (x < 0) {//题目要求，负数不回文
            return false;
        } else if (x == 0) {//首先排除0，以便后续处理
            return true;
        } else if (x % 10 == 0) {//修复bug：以0结尾，一定不回文
            return false;
        }
        int trans = 0;
        int temp;
        while (x > trans) {//转换到一半时，即可判断是否回文
            temp = x % 10;
            x /= 10;
            if (x == trans) {//若x位数为奇数，则 x移除末尾数后与转换数字相等 时，该数回文
                return true;
            }
            trans = trans * 10 + temp;
            if (x == trans) {//若x位数为偶数，则 x某次末尾数放入转换数字 并与其相等 时，回文
                return true;
            }
        }
        return false;
    }
}
