package main.problemAndSolving.leetcode_20200809WeekRankList;

import java.util.HashSet;
import java.util.Set;

//给你一个数组 nums 和一个整数 target 。
//
//请你返回 非空不重叠 子数组的最大数目，且每个子数组中数字和都为 target 。
//
//
//
//示例 1：
//
//输入：nums = [1,1,1,1,1], target = 2
//输出：2
//解释：总共有 2 个不重叠子数组（加粗数字表示） [1,1,1,1,1] ，它们的和为目标值 2 。
//示例 2：
//
//输入：nums = [-1,3,5,1,4,2,-9], target = 6
//输出：2
//解释：总共有 3 个子数组和为 6 。
//([5,1], [4,2], [3,5,1,4,2,-9]) 但只有前 2 个是不重叠的。
//示例 3：
//
//输入：nums = [-2,6,6,3,5,4,1,2,8], target = 10
//输出：3
//示例 4：
//
//输入：nums = [0,0,0], target = 0
//输出：3
//
//
//提示：
//
//1 <= nums.length <= 10^5
//-10^4 <= nums[i] <= 10^4
//0 <= target <= 10^6
public class T5471和为目标值的最大不重叠子数组数目 {
    public int maxNonOverlapping(int[] nums, int target) {
        int res = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();//存放待寻找的sum值
        set.add(target);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (set.contains(sum)) {
                set.clear();//不相交,清除此前记录的值
                sum = 0;//从下个位置重新计算
                set.add(target);//单个数组元素满足target的情况
                res++;
            } else {
                set.add(target + sum);//<=== futureContainTargetSum-sum=target 不要误弄成作差
            }
        }
        return res;
//        n^2复杂度即使结果正确也超时了，况且这段代码有bug，突然想到可以最后用辅助数组两两作差，即可得到，由此引发一个复杂度更低的想法，如上：
//        int[] aux = new int[nums.length];
//        int tag = 0;//已找到的数组的下标
//        int res = 0;
//        for (int i = 0; i + tag < nums.length; i++) {
//            for (int j = i + tag; j < nums.length; j++) {
//                if (aux[j] == target) {//找到一个数组，aux后续元素清零
//                    aux[j] = 0;
//                }
//                aux[j] += nums[i + tag];
//            }
//            if (aux[i + tag] == target) {//找到一个子数组，是从target到target+i
//                res++;
//                tag += i + 1;
//                i = -1;
//            }
//        }
//        return res;
    }
}
