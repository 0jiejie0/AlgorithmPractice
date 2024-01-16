package main.problemAndSolving.leetcode.leetcode_20220123WeekRankList;

//给你一个整数数组 nums ，统计并返回在 nums 中同时具有一个严格较小元素和一个严格较大元素的元素数目。
//
//
//
//示例 1：
//
//输入：nums = [11,7,2,15]
//输出：2
//解释：元素 7 ：严格较小元素是元素 2 ，严格较大元素是元素 11 。
//元素 11 ：严格较小元素是元素 7 ，严格较大元素是元素 15 。
//总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
//示例 2：
//
//输入：nums = [-3,3,3,90]
//输出：2
//解释：元素 3 ：严格较小元素是元素 -3 ，严格较大元素是元素 90 。
//由于有两个元素的值为 3 ，总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
//
//
//提示：
//
//1 <= nums.length <= 100
//-105 <= nums[i] <= 105
public class T5989元素计数 {
    public int countElements(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int min, max, countMin, countMax;
        min = max = nums[0];
        countMin = countMax = 1;
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
                countMin = 1;
            } else if (min == nums[i]) {
                countMin++;
            }
            if (max < nums[i]) {
                max = nums[i];
                countMax = 1;
            } else if (max == nums[i]) {
                countMax++;
            }

        }
        int res = nums.length - countMin - countMax;
        return res < 0 ? 0 : res;
    }
}
