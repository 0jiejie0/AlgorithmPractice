package main.problemAndSolving.leetcode_20201115WeekRankList;

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
        int res = nums.length + 1;
        //首先一个和变量从左端向右累加，和达x时停止，另外再有一个和变量用以从右向左计算
        int leftSum = 0, rightSum = 0;
        //初始化两个和变量对应下标，一个是记和位置，一个是右方末端
        int l = -1, r = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if ((leftSum += nums[i]) >= x) {
                l = i;
                break;
            }
        }
        if (l == -1) {//上个for中if没执行，说明所有和都小于x，没有符合条件的操作  此处排除了x大于全部元素和的情况
            return -1;
        }
        while (true) {
            if (-1 == l && nums.length == r) {//左和和右和都不含有元素，表明x小于任何一次求和，至少是首尾末端元素都大于x
                break;
            }
            //依次判断两和之和与x大小关系
            if (leftSum + rightSum == x) {//相等则通过下标计算两和所含元素数量，与历史最小数比对、保存，
                if (l + 1 + nums.length - r < res) {
                    res = l + 1 + nums.length - r;
                }
                // 后而左和弹出一个元素，右和加入一个元素，并移动下标
                if (l >= 0) {
                    leftSum -= nums[l--];
                }
                if (r > 0) {
                    rightSum += nums[--r];
                } else {//r==0表明所有元素都已加到右和中，再无可寻找条件
                    break;
                }
            } else if (leftSum + rightSum > x) {//大于则左和弹出一个元素，并移动下标
                if (l >= 0) {
                    leftSum -= nums[l--];
                } else {//左和已空，表明单右和已大于x，x条件从此不再满足
                    break;
                }
            } else {//小于则右和加入元素，并移动下标
                if (r > 0) {
                    rightSum += nums[--r];
                }
            }
        }
        // 所有结果中最小元素数即为所求
        if (nums.length + 1 == res) {//res未改变说明不满足条件
            res = -1;
        }
        return res;
    }
}
