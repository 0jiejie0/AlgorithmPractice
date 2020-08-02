package main.problemAndSolving.leetcode_20200802WeekRankList;

//你有两个 有序 且数组内元素互不相同的数组 nums1 和 nums2 。
//
//一条 合法路径 定义如下：
//
//选择数组 nums1 或者 nums2 开始遍历（从下标 0 处开始）。
//从左到右遍历当前数组。
//如果你遇到了 nums1 和 nums2 中都存在的值，那么你可以切换路径到另一个数组对应数字处继续遍历（但在合法路径中重复数字只会被统计一次）。
//得分定义为合法路径中不同数字的和。
//
//请你返回所有可能合法路径中的最大得分。
//
//由于答案可能很大，请你将它对 10^9 + 7 取余后返回。
//
// 
//
//示例 1：
//
//输入：nums1 = [2,4,5,8,10], nums2 = [4,6,8,9]
//输出：30
//解释：合法路径包括：
//[2,4,5,8,10], [2,4,5,8,9], [2,4,6,8,9], [2,4,6,8,10],（从 nums1 开始遍历）
//[4,6,8,9], [4,5,8,10], [4,5,8,9], [4,6,8,10]  （从 nums2 开始遍历）
//最大得分为上图中的绿色路径 [2,4,6,8,10] 。
//示例 2：
//
//输入：nums1 = [1,3,5,7,9], nums2 = [3,5,100]
//输出：109
//解释：最大得分由路径 [1,3,5,100] 得到。
//示例 3：
//
//输入：nums1 = [1,2,3,4,5], nums2 = [6,7,8,9,10]
//输出：40
//解释：nums1 和 nums2 之间无相同数字。
//最大得分由路径 [6,7,8,9,10] 得到。
//示例 4：
//
//输入：nums1 = [1,4,5,8,9,11,19], nums2 = [2,3,4,11,12]
//输出：61
// 
//
//提示：
//
//1 <= nums1.length <= 10^5
//1 <= nums2.length <= 10^5
//1 <= nums1[i], nums2[i] <= 10^7
//nums1 和 nums2 都是严格递增的数组。

public class T5478最大得分 {
    public int maxSum(int[] nums1, int[] nums2) {
        int res = 0;
        long up = 0, down = 0;
        int i = 0, j = 0;
        int mod = 1000 * 1000 * 1000 + 7;
        int diff;
        while (i < nums1.length && j < nums2.length) {
            diff = nums1[i] - nums2[j];
            if (diff < 0) {
                up += nums1[i++];//注意这里是取每一段的最大值，所以在求各段最大和的过程中不能取余
            } else if (diff > 0) {
                down += nums2[j++];
            } else {
                j++;
                res += (up > down ? up : down) % mod + nums1[i++];//为了防止加和溢出，在各段和计入结果前取余
                res %= mod;
                up = down = 0;
            }
        }
        while (i < nums1.length) {
            up += nums1[i++];
        }
        while (j < nums2.length) {
            down += nums2[j++];
        }
        res += (up > down ? up : down) % mod;
        return res % mod;
    }
}
