package main.problemAndSolving.leetcode_20240728WeekRankList;

import main.customUtil.AssertExample;

// 给你一个 正整数 数组 nums。
//
//小红和小明正在玩游戏。在游戏中，小红可以从 nums 中选择所有个位数 或 所有两位数，剩余的数字归小明所有。如果小红所选数字之和 严格大于 小明的数字之和，则小红获胜。
//
//如果小红能赢得这场游戏，返回 true；否则，返回 false。
//
//
//
//示例 1：
//
//输入：nums = [1,2,3,4,10]
//
//输出：false
//
//解释：
//
//小红不管选个位数还是两位数都无法赢得比赛。
//
//示例 2：
//
//输入：nums = [1,2,3,4,5,14]
//
//输出：true
//
//解释：
//
//小红选择个位数可以赢得比赛，所选数字之和为 15。
//
//示例 3：
//
//输入：nums = [5,5,5,25]
//
//输出：true
//
//解释：
//
//小红选择两位数可以赢得比赛，所选数字之和为 25。
//
//
//
//提示：
//
//1 <= nums.length <= 100
//1 <= nums[i] <= 99
public class TQ1判断是否可以赢得数字游戏 {
//    @AssertExample(params = {"[1,2,3,4,10]"}, expectResult="false")
//    @AssertExample(params = {"[1,2,3,4,5,14]"}, expectResult="true")
//    @AssertExample(params = {"[5,5,5,25]"}, expectResult="true")
    public boolean canAliceWin(int[] nums) {
        int single = 0, dbl = 0;
        for (int num : nums) {
            if (num > 9) {
                dbl += num;
            } else {
                single += num;
            }
        }
        return single != dbl;
    }
}
