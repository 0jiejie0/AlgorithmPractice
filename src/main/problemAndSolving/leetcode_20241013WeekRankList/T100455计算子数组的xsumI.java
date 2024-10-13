package main.problemAndSolving.leetcode_20241013WeekRankList;

import main.customUtil.AssertExample;

import java.util.Arrays;
import java.util.HashMap;

// 给你一个由 n 个整数组成的数组 nums，以及两个整数 k 和 x。
//
//数组的 x-sum 计算按照以下步骤进行：
//
//统计数组中所有元素的出现次数。
//仅保留出现次数最多的前 x 个元素的每次出现。如果两个元素的出现次数相同，则数值 较大 的元素被认为出现次数更多。
//计算结果数组的和。
//注意，如果数组中的不同元素少于 x 个，则其 x-sum 是数组的元素总和。
//
//返回一个长度为 n - k + 1 的整数数组 answer，其中 answer[i] 是 子数组 nums[i..i + k - 1] 的 x-sum。
//
//子数组 是数组内的一个连续 非空 的元素序列。
//
//
//
//示例 1：
//
//输入：nums = [1,1,2,2,3,4,2,3], k = 6, x = 2
//
//输出：[6,10,12]
//
//解释：
//
//对于子数组 [1, 1, 2, 2, 3, 4]，只保留元素 1 和 2。因此，answer[0] = 1 + 1 + 2 + 2。
//对于子数组 [1, 2, 2, 3, 4, 2]，只保留元素 2 和 4。因此，answer[1] = 2 + 2 + 2 + 4。注意 4 被保留是因为其数值大于出现其他出现次数相同的元素（3 和 1）。
//对于子数组 [2, 2, 3, 4, 2, 3]，只保留元素 2 和 3。因此，answer[2] = 2 + 2 + 2 + 3 + 3。
//示例 2：
//
//输入：nums = [3,8,7,8,7,5], k = 2, x = 2
//
//输出：[11,15,15,15,12]
//
//解释：
//
//由于 k == x，answer[i] 等于子数组 nums[i..i + k - 1] 的总和。
//
//
//
//提示：
//
//1 <= n == nums.length <= 50
//1 <= nums[i] <= 50
//1 <= x <= k <= nums.length
public class T100455计算子数组的xsumI {
    @AssertExample(params = {"[1,1,2,2,3,4,2,3]", "6", "2"}, expectResult = "[6,10,12]")
    @AssertExample(params = {"[3,8,7,8,7,5]", "2", "2"}, expectResult = "[11,15,15,15,12]")
    public int[] findXSum(int[] nums, int k, int x) {
        int[] ans = new int[nums.length - k + 1];
        if (k == x) {
            int sub = 0;
            for (int i = 0; i < k; i++) {
                sub += nums[i];
            }
            ans[0] = sub;
            for (int i = 1; i < nums.length - k + 1; i++) {
                sub -= nums[i - 1];
                sub += nums[i + k - 1];
                ans[i] = sub;
            }
            return ans;
        }
        int[] sub = new int[51];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sub[nums[i]]++;
        }
        int[] temp = Arrays.copyOf(sub, sub.length);
        int[] top = new int[x];
        int index = 0;
        Arrays.sort(temp);
        for (int i = temp.length - 1; i >= 0; i--) {
            if (temp[i] == 0) {
                break;
            }
            top[index++] = temp[i];
            if (index == x) {
                break;
            }
        }
        index = 0;
        temp = Arrays.copyOf(sub, sub.length);
        for (int i = 0; i < x; i++) {
            if (top[i] == 0) {
                break;
            }
            for (int i1 = temp.length - 1; i1 >= 0; i1--) {
                if (temp[i1] == top[i]) {
                    sum += i1 * top[i];
                    temp[i1] = 0;
                    break;
                }
            }
        }
        ans[0] = sum;
        sum=0;
        for (int j = 1; j < nums.length - k + 1; j++) {
            sub[nums[j - 1]]--;
            sub[nums[j + k - 1]]++;

            int[] temp1 = Arrays.copyOf(sub, sub.length);
            int[] top1 = new int[x];
            int index1 = 0;
            Arrays.sort(temp1);
            for (int i = temp1.length - 1; i >= 0; i--) {
                if (temp1[i] == 0) {
                    break;
                }
                top1[index1++] = temp1[i];
                if (index1 == x) {
                    break;
                }
            }
            index1 = 0;
            temp1 = Arrays.copyOf(sub, sub.length);
            for (int i = 0; i < x; i++) {
                if (top1[i] == 0) {
                    break;
                }
                for (int i1 = temp1.length - 1; i1 >= 0; i1--) {
                    if (temp1[i1] == top1[i]) {
                        sum += i1 * top1[i];
                        temp1[i1] = 0;
                        break;
                    }
                }
            }
            ans[j] = sum;
            sum=0;
        }
        return ans;
    }
}
