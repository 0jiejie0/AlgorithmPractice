package main.problemAndSolving.leetcode_20240609WeekRankList;

import java.util.Arrays;

// 给你一个整数数组 rewardValues，长度为 n，代表奖励的值。
//
//最初，你的总奖励 x 为 0，所有下标都是 未标记 的。你可以执行以下操作 任意次 ：
//
//从区间 [0, n - 1] 中选择一个 未标记 的下标 i。
//如果 rewardValues[i] 大于 你当前的总奖励 x，则将 rewardValues[i] 加到 x 上（即 x = x + rewardValues[i]），并 标记 下标 i。
//以整数形式返回执行最优操作能够获得的 最大 总奖励。
//
//
//
//示例 1：
//
//输入：rewardValues = [1,1,3,3]
//
//输出：4
//
//解释：
//
//依次标记下标 0 和 2，总奖励为 4，这是可获得的最大值。
//
//示例 2：
//
//输入：rewardValues = [1,6,4,3,2]
//
//输出：11
//
//解释：
//
//依次标记下标 0、2 和 1。总奖励为 11，这是可获得的最大值。
//
//
//
//提示：
//
//1 <= rewardValues.length <= 2000
//1 <= rewardValues[i] <= 2000
public class T100319执行操作可获得的最大总奖励I {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int ans = rewardValues[rewardValues.length - 1];
        int n = ans - 1;
        int sum = n;
        while (sum > 0) {
            for (int i = rewardValues.length - 2; i >= 0; i--) {
                // while逻辑：将n依次减去数组各元素值（跳过重复或大于n的值）
                while (i >= 0 && rewardValues[i] <= n) {
                    while (i >= 0 && rewardValues[i] == rewardValues[i + 1]) { // 重复值
                        i--;
                    }
                    if (i >= 0) { // 当前元素不是重复元素且小于等于n，与n作差
                        n = n - rewardValues[i];
                        i--;
                    }
                }
                if (0 == n) { // n扣除若干元素后为0，满足条件
                    ans += sum;
                    return ans;
                }
            }
            sum--;
            n = sum;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new T100319执行操作可获得的最大总奖励I().maxTotalReward(new int[]{1, 3, 1, 3}));
    }
}
// 这个逻辑果然不对，提交没有通过，每次取最大并不是最优值
// 应该算，扣除最大元素后，剩余元素能否累加得到 最大元素减一（或逐次递减）
// 但这样的复杂度，恐怕是2k*2k！
// 求子数组内是否存在某几个元素相加得某和

// 例如 [6,13,9,19] ，其结果是34，每次取最大只能得到32
