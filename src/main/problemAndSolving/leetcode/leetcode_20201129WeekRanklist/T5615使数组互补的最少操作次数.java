package main.problemAndSolving.leetcode.leetcode_20201129WeekRanklist;

//给你一个长度为 偶数 n 的整数数组 nums 和一个整数 limit 。每一次操作，你可以将 nums 中的任何整数替换为 1 到 limit 之间的另一个整数。
//
//如果对于所有下标 i（下标从 0 开始），nums[i] + nums[n - 1 - i] 都等于同一个数，则数组 nums 是 互补的 。例如，数组 [1,2,3,4] 是互补的，
// 因为对于所有下标 i ，nums[i] + nums[n - 1 - i] = 5 。
//
//返回使数组 互补 的 最少 操作次数。
//
// 
//
//示例 1：
//
//输入：nums = [1,2,4,3], limit = 4
//输出：1
//解释：经过 1 次操作，你可以将数组 nums 变成 [1,2,2,3]（加粗元素是变更的数字）：
//nums[0] + nums[3] = 1 + 3 = 4.
//nums[1] + nums[2] = 2 + 2 = 4.
//nums[2] + nums[1] = 2 + 2 = 4.
//nums[3] + nums[0] = 3 + 1 = 4.
//对于每个 i ，nums[i] + nums[n-1-i] = 4 ，所以 nums 是互补的。
//示例 2：
//
//输入：nums = [1,2,2,1], limit = 2
//输出：2
//解释：经过 2 次操作，你可以将数组 nums 变成 [2,2,2,2] 。你不能将任何数字变更为 3 ，因为 3 > limit 。
//示例 3：
//
//输入：nums = [1,2,1,2], limit = 2
//输出：0
//解释：nums 已经是互补的。
// 
//
//提示：
//
//n == nums.length
//2 <= n <= 105
//1 <= nums[i] <= limit <= 105
//n 是偶数。
public class T5615使数组互补的最少操作次数 {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length >> 1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] += nums[nums.length - i - 1];
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int[][] counts = new int[max + 1][(max - 1) / limit + 2];
        for (int i = 0; i < n; i++) {
            counts[nums[i]][0]++;//计数排序
        }
        //统计到数字i的距离为j倍limit区间的和的数量
        for (int i = 1; i < counts.length; i++) {
            if (i == 1) {//首元素初始化，复杂度O(limit)
                for (int j = limit + i; j < max + limit; j += limit) {
                    if (j == limit + i) {
                        counts[i][1] += counts[i][0];
                    }
                    for (int k = j - limit + 1; k <= j && k < counts.length; k++) {//(j-limit,j]
                        counts[i][j / limit] += counts[k][0];//i为中心，limit为长度的区间，k为区间内的数字，将其个数记到中心对应位置
                    }
                }
            } else {//后续元素利用前序元素计算，复杂度O(1)
                for (int j = limit; j < max + limit; j += limit) {
                    counts[i][j / limit] = counts[i - 1][j / limit];
                    if (0 < i - j) {//左端点
                        counts[i][j / limit] -= counts[i - j][0];
                    }
                    if (i + j <= max) {//右端点
                        counts[i][j / limit] += counts[i + j][0];
                    }
                }
            }
        }
        //依次检查 以各个点为中心的区间内元素个数*调整倍数 ，记录最小值
        int res = Integer.MAX_VALUE, temp;
        for (int[] count : counts) {
            temp = 0;
            for (int i = 1; i < count.length; i++) {
                count[i] -= count[0];
                temp += count[i] * i;
            }
            if (temp < res) {
                res = temp;
            }
        }
        return res;
    }
}
