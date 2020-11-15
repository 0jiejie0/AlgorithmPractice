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
        //首先建立2个长度为n的数组，
        int[] leftToRight = new int[nums.length];
        int[] rightToLeft = new int[nums.length];
        int l = -1, r = -1, res = nums.length + 1;
        // 在数组中生成预处理数据（原数组 从左到右或从右到左累加当前长度的元素 和）
        leftToRight[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftToRight[i] = leftToRight[i - 1] + nums[i];
            //预处理至当前和大于等于x时停止（再大的数据已不需要）
            //记录生成的数据在数组中的范围下标
            if (leftToRight[i] >= x) {
                l = i;
                break;
            }
        }
        rightToLeft[0] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            rightToLeft[i] = rightToLeft[i - 1] + nums[nums.length - i - 1];
            if (rightToLeft[i] >= x) {
                r = i;
                break;
            }
        }
        //从一个数组的尾端扫描+从另一个数组的起点扫描，
        int a = l, b = -1;
        while (a >= -1 && b <= r) {
            //ab为-1说明从一端操作，只记一个数组
            if (a == -1) {//ltor数组结束扫描
                if (b < 0) {//ab同为-1说明最小和也小于x，不能得到x
                    break;
                }
                if (rightToLeft[b] < x) {
                    b++;
                } else {
                    if (rightToLeft[b] == x) {
                        if (b + 1 < res) {
                            res = b + 1;
                        }
                    }
                    break;
                }
            } else if (b == -1) {//rtol数组未开始扫描
                if (leftToRight[a] == x) {//判断左端的累加操作是否满足条件
                    if (a + 1 < res) {
                        res = a + 1;
                    }
                    a--;
                } else if (leftToRight[a] > x) {
                    a--;
                } else {
                    b++;
                }
            } else {
                if (leftToRight[a] + rightToLeft[b] == x) {
                    // 记录所有和为x的两元素的下标和，与历史最小下标和比较，
                    if (a + b + 2 < res) {
                        res = a + b + 2;
                    }
                    a--;
                    b++;
                } else if (leftToRight[a] + rightToLeft[b] > x) {
                    a--;
                } else {
                    b++;
                }
            }
        }
        // 所有结果中最小下标和即为所求
        if (nums.length + 1 == res) {
            res = -1;
        }
        return res;
    }
}
