package main.problemAndSolving.leetcode.leetcode_20220717WeekRankList;

//给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与  nums[j] 的数位和相等。
//
//请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
//
// 
//
//示例 1：
//
//输入：nums = [18,43,36,13,7]
//输出：54
//解释：满足条件的数对 (i, j) 为：
//- (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
//- (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
//所以可以获得的最大和是 54 。
//示例 2：
//
//输入：nums = [10,12,19,14]
//输出：-1
//解释：不存在满足条件的数对，返回 -1 。
// 
//
//提示：
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 109
public class T6164数位和相等数对的最大和 {
    public int maximumSum(int[] nums) {
        int res = -1;
        int[] temp = new int[nums.length];//记录所有数位和
        int[] cache = new int[82];
        int add = 0;//计算数位和的临时变量
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            while (n > 0) {
                add += n % 10;
                n /= 10;
            }
            temp[i] = add;
            add = 0;
        }
        int sum = 0;
        for (int i = 0; i < temp.length; i++) {
            int n = nums[i];
            int a = temp[i];
            if (cache[a] == 0) {
                cache[a] = n;
            } else {
                sum = cache[a] + n;
                if (sum > res) {
                    res = sum;
                }
                if (cache[a] <= n) {
                    cache[a] = n;
                }
            }
            sum = 0;
        }
        return res;
    }
}
