package main.leetcode_20200117;

public class Solution {
    /**
     * 525. 连续数组
     * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
     * 示例 1:
     * 输入: [0,1]
     * 输出: 2
     * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
     * 示例 2:
     * 输入: [0,1,0]
     * 输出: 2
     * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
     * 注意: 给定的二进制数组的长度不会超过50000。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/contiguous-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 解题思路一：[平方复杂度，最大数据规模50000，提交超时！！！]
     * 1、采用两层循环，外层循环限定查找起点，内存循环限定查找终点，起点和终点以及中间的元素作为计算范围
     * 2、起点从0号位置开始，length（数组长度）-2位置结束（因为最后一个元素只是一个元素，一个元素不可能单独组成符合要求的子数组）
     * 3、终点从起点位置+1开始，length-1位置（末尾）结束
     * 4、终点每次挪动两个位置
     * 5、每次挪动终点累加计算新加入计算范围的两个元素，比较计算范围长度与历史最长子数组长度，计算范围长则更新记录
     * 解题思路二：[1158 ms]
     * 1、在全长范围内找到最长子数组（仅限定偶数个元素，不限定01等量）的和以及长度
     * 2、依次检查定长子数组，根据出入数组元素调整当前数组和
     * 3、子数组和为0，符合条件，返回；否则不符合条件，继续检查下一个数组
     * 4、当前长度的所有子数组检查均不合条件，将长度缩短，继续搜索
     * 优化一：[1308 ms]
     * 1、当前范围的01差量限制了最长子数组长度<=当前范围长度-差量
     *
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        int maxSum = 0;
//        int nowSum;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
            maxSum += nums[i];
        }
        int length = nums.length;
        if (maxSum > 0) {//优化一，maxSum绝对值代表了01量差，从length中去除这一部分
            length -= maxSum;
        } else {
            length += maxSum;
        }
        for (int i = length; i < nums.length; i++) {
            maxSum -= nums[i];//从总和中去除多余部分的值
        }
        maxLength = findMaxLength(nums, maxSum, length);
//        if (length % 2 == 0) {
//            maxLength = findMaxLength(nums, maxSum, length);
//        } else {
//            length--;
//            maxLength = findMaxLength(nums, maxSum - nums[length], length);
//        }
//        for (int start = 0; start < nums.length - 1; start++) {
//            nowSum = 0;
//            for (int end = start + 1; end < nums.length; end += 2) {
//                nowSum += nums[end - 1];
//                nowSum += nums[end];
//                if (nowSum == 0 && ((end - start + 1) > maxLength)) {
//                    maxLength = end - start + 1;
//                }
//            }
//        }
        return maxLength;
    }

    /**
     * 在定长范围内寻找最长01同量的子数组
     *
     * @param nums   经过转化的数组
     * @param sum    指定长度的和
     * @param length 指定长度，且为偶数
     * @return 最长子数组的长度
     */
    private int findMaxLength(int[] nums, int sum, int length) {
        int tempSum = sum;
        int range = nums.length - length + 1;
        for (int i = 0; i < range; i++) {
            if (tempSum == 0) {//依次检查指定长度子数组的和，和为0表示原数组01等量
                return length;
            }
            //继续向后检查
            tempSum -= nums[i];
            try {
                tempSum += nums[i + length];
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        当前长度的所有子数组都不能满足条件，缩短长度继续寻找
        sum -= nums[length - 1];
        sum -= nums[length - 2];
        return findMaxLength(nums, sum, length - 2);
    }
}