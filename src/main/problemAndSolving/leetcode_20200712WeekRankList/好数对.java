package main.problemAndSolving.leetcode_20200712WeekRankList;
//5460. 好数对的数目 显示英文描述 
//通过的用户数0
//尝试过的用户数0
//用户总通过次数0
//用户总提交次数0
//题目难度Easy
//给你一个整数数组 nums 。
//
//如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
//
//返回好数对的数目。
//
// 
//
//示例 1：
//
//输入：nums = [1,2,3,1,1,3]
//输出：4
//解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
//示例 2：
//
//输入：nums = [1,1,1,1]
//输出：6
//解释：数组中的每组数字都是好数对
//示例 3：
//
//输入：nums = [1,2,3]
//输出：0
// 
//
//提示：
//
//1 <= nums.length <= 100
//1 <= nums[i] <= 100

public class 好数对 {
    public int numIdenticalPairs(int[] nums) {
        int[] arr = new int[101];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += arr[nums[i]]++;//吸收下面一题（仅含1的子串数）的经验，同理改良
        }
//        for (int i = 1; i < arr.length; i++) {
//            res += (arr[i] * (arr[i] - 1)) >> 1;
//        }
        return res;
    }
}
