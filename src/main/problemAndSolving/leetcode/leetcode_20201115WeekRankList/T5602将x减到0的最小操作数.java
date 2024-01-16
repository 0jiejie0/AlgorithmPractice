package main.problemAndSolving.leetcode.leetcode_20201115WeekRankList;

//给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
//
//如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
//
//
//
//示例 1：
//
//输入：nums = [1,1,4,2,3], x = 5
//输出：2
//解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
//示例 2：
//
//输入：nums = [5,6,7,8,9], x = 4
//输出：-1
//示例 3：
//
//输入：nums = [3,2,20,1,1,3], x = 10
//输出：5
//解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
//
//
//提示：
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 104
//1 <= x <= 109
public class T5602将x减到0的最小操作数 {
    public int minOperations(int[] nums, int x) {
        //优化思路：无需先建立记和数组，只需要两个变量，在计算过程中对和累加或减去一个元素即可
        //优化思路2：反向求和，对nums中所有元素求x补集的和，此时只要在各个连续子数组中找补集和，以简化比较大小的逻辑代码
        if (x < nums[0] && x < nums[nums.length - 1]) {//x小于首尾元素，无满足条件的操作
            return -1;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum <= x) {//所有元素和小于x，不可满足条件，等于x则只有一次最大的操作数
            return sum == x ? nums.length : -1;
        }
        sum -= x;//补集和
        int resComple = -1;//补集元素最大数
        int l = 0, r = 1;
        int currentSum = nums[0];
        int tempSum = currentSum;
        while (true) {
            //从一端（左端）开始，查看当前计算区间内元素和与补集和的大小关系，
            //区间元素和等于补集和，比较区间内元素数和补集最大数resComple比较，保留较大值,并移动左右端点（放在后续步骤进行）
            if (currentSum == sum) {
                if (r - l > resComple) {
                    resComple = r - l;
                }
            }
            // 区间元素和大于等于补集和则左端点右移，区间元素小于补集和则右端点右移
            if (currentSum >= sum) {
                tempSum -= nums[l++];
            }
            if (currentSum <= sum) {
                if (r == nums.length) {//循环控制在右端点移动到数组末端前
                    break;
                }
                tempSum += nums[r++];
            }
            currentSum = tempSum;
        }
        return resComple == -1 ? -1 : (nums.length - resComple);
    }
}
