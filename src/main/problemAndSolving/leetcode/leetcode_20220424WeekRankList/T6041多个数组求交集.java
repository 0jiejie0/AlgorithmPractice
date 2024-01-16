package main.problemAndSolving.leetcode.leetcode_20220424WeekRankList;

import java.util.LinkedList;
import java.util.List;

//给你一个二维整数数组 nums ，其中 nums[i] 是由 不同 正整数组成的一个非空数组，按 升序排列 返回一个数组，数组中的每个元素在 nums 所有数组 中都出现过。
//
//
//
//示例 1：
//
//输入：nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
//输出：[3,4]
//解释：
//nums[0] = [3,1,2,4,5]，nums[1] = [1,2,3,4]，nums[2] = [3,4,5,6]，在 nums 中每个数组中都出现的数字是 3 和 4 ，所以返回 [3,4] 。
//示例 2：
//
//输入：nums = [[1,2,3],[4,5,6]]
//输出：[]
//解释：
//不存在同时出现在 nums[0] 和 nums[1] 的整数，所以返回一个空列表 [] 。
//
//
//提示：
//
//1 <= nums.length <= 1000
//1 <= sum(nums[i].length) <= 1000
//1 <= nums[i][j] <= 1000
//nums[i] 中的所有值 互不相同
public class T6041多个数组求交集 {
    public List<Integer> intersection(int[][] nums) {
        int[] temp = new int[1001];//下标对应原数，元素值记录数值出现次数，最后提取等于数据组数num长度的数据，返回结果
        for (int[] ns : nums) {
            for (int n : ns) {
                temp[n]++;
            }
        }
        List<Integer> res = new LinkedList<>();
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == nums.length) {
                res.add(i);
            }
        }
        return res;
    }
}
