package main.leetcode.editor.cn;//给你一个整数数组 nums 和一个 非负 整数 k 。一次操作中，你可以选择任一元素 加 1 或者减 1 。
//
// 请你返回将 nums 中位数 变为 k 所需要的 最少 操作次数。 
//
// 一个数组的中位数指的是数组按非递减顺序排序后最中间的元素。如果数组长度为偶数，我们选择中间两个数的较大值为中位数。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [2,5,6,8,5], k = 4 
// 
//
// 输出：2 
//
// 解释：我们将 nums[1] 和 nums[4] 减 1 得到 [2, 4, 6, 8, 4] 。现在数组的中位数等于 k 。 
//
// 示例 2： 
//
// 
// 输入：nums = [2,5,6,8,5], k = 7 
// 
//
// 输出：3 
//
// 解释：我们将 nums[1] 增加 1 两次，并且将 nums[2] 增加 1 一次，得到 [2, 7, 7, 8, 5] 。 
//
// 示例 3： 
//
// 
// 输入：nums = [1,2,3,4,5,6], k = 4 
// 
//
// 输出：0 
//
// 解释：数组中位数已经等于 k 了。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= k <= 10⁹ 
// 
//
// 👍 3 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        long ans = 0;
        if (nums.length == 1) return nums[0] > k ? nums[0] - k : k - nums[0];
        Arrays.sort(nums);
        int m = nums.length >> 1;
        if (nums[m] == k) return ans;
        if (nums[m] < k) {
            for (int i = m; i < nums.length; i++) {
                if (k <= nums[i]) break;
                ans += (k - nums[i]);
            }
        } else {
            for (int i = m; i >= 0; i--) {
                if (k >= nums[i]) break;
                ans += (nums[i] - k);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//	执行耗时:31 ms,击败了99.84% 的Java用户
//	内存消耗:61.1 MB,击败了69.84% 的Java用户