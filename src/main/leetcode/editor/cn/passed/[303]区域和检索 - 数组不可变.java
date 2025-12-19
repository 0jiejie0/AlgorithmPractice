package main.leetcode.editor.cn;//给定一个整数数组 nums，处理以下类型的多个查询:
//
// 
// 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right 
// 
//
// 实现 NumArray 类： 
//
// 
// NumArray(int[] nums) 使用数组 nums 初始化对象 
// int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 
//right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] ) 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["NumArray", "sumRange", "sumRange", "sumRange"]
//[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//输出：
//[null, 1, -1, -3]
//
//解释：
//NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
//numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
//numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
//numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 0 <= i <= j < nums.length 
// 最多调用 10⁴ 次 sumRange 方法 
// 
//
// Related Topics 设计 数组 前缀和 👍 687 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {
    long[] cache;
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        cache = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cache[i] = Long.MIN_VALUE;
        }
        cache[0] = nums[0];
    }

    public int sumRange(int left, int right) {
        long l = cache[0];
        int i = 0;
        while (i < cache.length && cache[i] != Long.MIN_VALUE) {
            l = cache[i++];
        }
        for (; cache[right] == Long.MIN_VALUE; i++) {
            if (cache[i] == Long.MIN_VALUE) {
                cache[i] = l += nums[i];
            }
        }
        return (int) (left == 0 ? cache[right] : (cache[right] - cache[left - 1]));
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)


// 	执行耗时:68 ms,击败了5.12% 的Java用户
//	内存消耗:48.5 MB,击败了28.24% 的Java用户
// 这个效率有点低啊？
// 数据预处理效率确实太慢，平方复杂度，怎么优化呢？

// 	执行耗时:72 ms,击败了5.19% 的Java用户
//	内存消耗:48.6 MB,击败了7.31% 的Java用户
// 纯纯负优化，每次查询时初始化一部分并没有提升性能，反而浪费了时间用来判断
