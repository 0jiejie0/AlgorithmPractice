package main.problemAndSolving.leetcode_20241201WeekRankList;

import main.customUtil.AssertExample;

import java.util.Arrays;

//给你一个整数数组 nums。该数组包含 n 个元素，其中 恰好 有 n - 2 个元素是 特殊数字 。剩下的 两个 元素中，一个是这些 特殊数字 的 和 ，另一个是 异常值 。
//
//异常值 的定义是：既不是原始特殊数字之一，也不是表示这些数字元素和的数字。
//
//注意，特殊数字、和 以及 异常值 的下标必须 不同 ，但可以共享 相同 的值。
//
//返回 nums 中可能的 最大异常值。
//
//
//
//示例 1：
//
//输入： nums = [2,3,5,10]
//
//输出： 10
//
//解释：
//
//特殊数字可以是 2 和 3，因此和为 5，异常值为 10。
//
//示例 2：
//
//输入： nums = [-2,-1,-3,-6,4]
//
//输出： 4
//
//解释：
//
//特殊数字可以是 -2、-1 和 -3，因此和为 -6，异常值为 4。
//
//示例 3：
//
//输入： nums = [1,1,1,1,1,5,5]
//
//输出： 5
//
//解释：
//
//特殊数字可以是 1、1、1、1 和 1，因此和为 5，另一个 5 为异常值。
//
//
//
//提示：
//
//3 <= nums.length <= 105
//-1000 <= nums[i] <= 1000
//输入保证 nums 中至少存在 一个 可能的异常值。
public class T100444识别数组中的最大异常值 {
//        @AssertExample(params = "[2,3,5,10]", expectResult = "10")
//    @AssertExample(params = "[-2,-1,-3,-6,4]", expectResult = "4")
    public int getLargestOutlier(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (((nums[i] ^ sum) & 1) == 0) {
                sum -= nums[i];
                int l = 0, r = nums.length;
                int m = (l + r) >> 1;
                if (sum > 0) {
                    while (l < r) { // 搜和挨个找太费时间了，超时了，得用二分
                        if (sum == (nums[m] << 1)) {
                            if (m == i) {
                                if (l > 0) {
                                    l--;
                                } else {
                                    r--;
                                }
                                continue;
                            }
                            return nums[i];
                        } else if (sum < (nums[m] << 1)) {
                            r = m;
                        } else {
                            l = m + 1;
                        }
                        m = (l + r) >> 1;
                    }
                } else {
                    while (l < r) {
                        if (sum == (nums[m] << 1)) {
                            if (m == i) {
                                if (r < nums.length) {
                                    r++;
                                } else {
                                    l++;
                                }
                                continue;
                            }
                            return nums[i];
                        } else if (sum < (nums[m] << 1)) {
                            r = m;
                        } else {
                            l = m + 1;
                        }
                        m = (l + r) >> 1;
                    }
                }
                sum += nums[i];
            }
        }
        return nums[0];
    }
}

// 872 / 872 个通过测试用例
//状态：通过
//执行用时: 76 ms
//内存消耗: 63 MB
