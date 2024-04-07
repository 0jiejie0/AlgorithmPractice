package main.problemAndSolving.leetcode_20240407WeekRankList;

//给你一个整数数组 nums 。
//
//返回数组 nums 中 严格递增 或 严格递减 的最长非空子数组的长度。
//
//
//
//示例 1：
//
//输入：nums = [1,4,3,3,2]
//
//输出：2
//
//解释：
//
//nums 中严格递增的子数组有[1]、[2]、[3]、[3]、[4] 以及 [1,4] 。
//
//nums 中严格递减的子数组有[1]、[2]、[3]、[3]、[4]、[3,2] 以及 [4,3] 。
//
//因此，返回 2 。
//
//示例 2：
//
//输入：nums = [3,3,3,3]
//
//输出：1
//
//解释：
//
//nums 中严格递增的子数组有 [3]、[3]、[3] 以及 [3] 。
//
//nums 中严格递减的子数组有 [3]、[3]、[3] 以及 [3] 。
//
//因此，返回 1 。
//
//示例 3：
//
//输入：nums = [3,2,1]
//
//输出：3
//
//解释：
//
//nums 中严格递增的子数组有 [3]、[2] 以及 [1] 。
//
//nums 中严格递减的子数组有 [3]、[2]、[1]、[3,2]、[2,1] 以及 [3,2,1] 。
//
//因此，返回 3 。
//
//
//
//提示：
//
//1 <= nums.length <= 50
//1 <= nums[i] <= 50
public class T100264最长的严格递增或递减子数组 {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) return 1;
        int ans = 1, last = nums[0], count = 1;
        for (int i = 1; i < nums.length; ) {
            while (i < nums.length && nums[i] > last) {
                count++;
                last = nums[i];
                i++;
            }
            if (count > ans) ans = count;
            count = 1;
            while (i < nums.length && nums[i] < last) {
                count++;
                last = nums[i];
                i++;
            }
            if (count > ans) ans = count;
            count = 1;
            while (i < nums.length && nums[i] == last) i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new T100264最长的严格递增或递减子数组().longestMonotonicSubarray(new int[]{2, 1, 2, 4}));
    }
}
