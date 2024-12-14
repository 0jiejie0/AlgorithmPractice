package main.leetcode.editor.cn;//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
//
// 
//
// 示例 1: 
//
// 
//输入: num = 38
//输出: 2 
//解释: 各位相加的过程为：
//38 --> 3 + 8 --> 11
//11 --> 1 + 1 --> 2
//由于 2 是一位数，所以返回 2。
// 
//
// 示例 2: 
//
// 
//输入: num = 0
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你可以不使用循环或者递归，在 O(1) 时间复杂度内解决这个问题吗？ 
//
// Related Topics 数学 数论 模拟 👍 703 👎 0


import main.customUtil.AssertExample;

import java.util.ArrayList;
import java.util.TreeMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    @AssertExample(params = "38", expectResult = "0")
    public int addDigits(int num) {
        // 进阶要求是O（1）完成，十进制各位数字相加应该就不是简单的位运算了
        // 数论似乎有所耳闻啊，但是又没学过
        // 看了看题解，没想到，竟然只需要一行代码就能完成，不过，模运算的效率似乎没有很高？

        // 能不能继续推广到其他进制呢？
        // m进制表示数的数根，对m-1取模似乎总能求得

        // 这个思路将m进制各位加和，转换为对m-1的取模运算，如果要再进一步，似乎当前的思路就无法继续应用了
        return (num - 1) % 9 + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:40.2 MB,击败了6.68% 的Java用户
// 内存消耗有这么要命吗？