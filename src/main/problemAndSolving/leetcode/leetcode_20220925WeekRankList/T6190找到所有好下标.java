package main.problemAndSolving.leetcode.leetcode_20220925WeekRankList;

import java.util.LinkedList;
import java.util.List;

//给你一个大小为 n 下标从 0 开始的整数数组 nums 和一个正整数 k 。
//
//对于 k <= i < n - k 之间的一个下标 i ，如果它满足以下条件，我们就称它为一个 好 下标：
//
//下标 i 之前 的 k 个元素是 非递增的 。
//下标 i 之后 的 k 个元素是 非递减的 。
//按 升序 返回所有好下标。
//
//
//
//示例 1：
//
//输入：nums = [2,1,1,1,3,4,1], k = 2
//输出：[2,3]
//解释：数组中有两个好下标：
//- 下标 2 。子数组 [2,1] 是非递增的，子数组 [1,3] 是非递减的。
//- 下标 3 。子数组 [1,1] 是非递增的，子数组 [3,4] 是非递减的。
//注意，下标 4 不是好下标，因为 [4,1] 不是非递减的。
//示例 2：
//
//输入：nums = [2,1,1,2], k = 2
//输出：[]
//解释：数组中没有好下标。
//
//
//提示：
//
//n == nums.length
//3 <= n <= 105
//1 <= nums[i] <= 106
//1 <= k <= n / 2
public class T6190找到所有好下标 {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> ans = new LinkedList<>();
        if (k == (nums.length >> 1)) {
            return ans;
        }
        int min = nums[0], max = nums[k + 1], s = 0;
        for (int i = 1; i - s < k; i++) {
            if (nums[k + 1 + i] < max) {
                s = k + i;
                i = s;
                min = nums[i];
                max = nums[k + 1 + i];
            }
            if (nums[i] > min) {
                s = i;
                min = nums[i];
                max = nums[k + 1 + i];
            }
            //思路（不一定正确）：从前向后两个k长度的区间内，一个不递增，一个不递减，从前向后依次检查新加入区间的元素是否符合条件
            //检查两个点，一个是中间的i（题意中的）点小于等于左区间最小值，一个是右区间右侧的点大于等于右区间最大值，两条件满足则i为好下标
            //若右侧的点不满足要求，则从该点的前一点重新开始计算两个区间
            //若中间的点不满足要求，则从该点重新开始计算两个区间
            //从前向后检查，好下标添加到list中，一直到右区间检查到数组nums末尾为止
        }
        return ans;
    }
}
