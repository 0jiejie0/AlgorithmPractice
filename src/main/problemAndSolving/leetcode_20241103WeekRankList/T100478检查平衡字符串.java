package main.problemAndSolving.leetcode_20241103WeekRankList;

// 给你一个仅由数字 0 - 9 组成的字符串 num。如果偶数下标处的数字之和等于奇数下标处的数字之和，则认为该数字字符串是一个 平衡字符串。
//
//如果 num 是一个 平衡字符串，则返回 true；否则，返回 false。
//
//
//
//示例 1：
//
//输入：num = "1234"
//
//输出：false
//
//解释：
//
//偶数下标处的数字之和为 1 + 3 = 4，奇数下标处的数字之和为 2 + 4 = 6。
//由于 4 不等于 6，num 不是平衡字符串。
//示例 2：
//
//输入：num = "24123"
//
//输出：true
//
//解释：
//
//偶数下标处的数字之和为 2 + 1 + 3 = 6，奇数下标处的数字之和为 4 + 2 = 6。
//由于两者相等，num 是平衡字符串。
//
//
//提示：
//
//2 <= num.length <= 100
//num 仅由数字 0 - 9 组成。
public class T100478检查平衡字符串 {
    public boolean isBalanced(String num) {
        int cache = 0;
        char[] charArray = num.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (0 == (1 & i)) {
                cache += (charArray[i] - '0');
            } else {
                cache -= (charArray[i] - '0');
            }
        }
        return cache == 0;
    }
}
