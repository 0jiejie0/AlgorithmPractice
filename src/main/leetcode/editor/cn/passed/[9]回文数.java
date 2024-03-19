package main.leetcode.editor.cn.passed;//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 
// 例如，121 是回文，而 123 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
//
// Related Topics 数学 👍 2809 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 最开始借鉴了某题解翻转字符串和原串比较相等的思想，把原数各位余数翻转到新数中，和原数比较；
     * 编写过程中发现，反转到一半就可以比较了，没必要全转过来，同时把开头的if去掉少一步判断；
     * 最后因为尾数0，在循环中加了个判断，第一次拿到的余数为0否。
     * 目测每次循环判断一下这个if可能也会耗时，但是把第一遍循环拿出来以后，性能似乎没什么改观。再调整一下，没啥改观
     * 再看看别人的题解，基本和官方题解相似了，不同的是对0和末尾0的处理有所区别，但是我认为我的优，因为重复计算最少
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        int t = 0;
        if (x > 0) {
            if ((t = x % 10) == 0) return false;
            x /= 10;
        } else return x == 0;
        while (x > t) {
            t = t * 10 + x % 10;
            x /= 10;
        }
        return x == t || x == t / 10;
        // 	执行耗时:4 ms,击败了100.00% 的Java用户
        //	内存消耗:42.7 MB,击败了84.19% 的Java用户
    }
}
//leetcode submit region end(Prohibit modification and deletion)
