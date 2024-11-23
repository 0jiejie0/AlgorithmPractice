//给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,3,1] 
// 
//
// 输出：true 
//
// 解释： 
//
// 元素 1 在下标 0 和 3 出现。 
//
// 示例 2： 
//
// 
// 输入：nums = [1,2,3,4] 
// 
//
// 输出：false 
//
// 解释： 
//
// 所有元素都不同。 
//
// 示例 3： 
//
// 
// 输入：nums = [1,1,1,3,3,4,3,2,4,2] 
// 
//
// 输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 排序 👍 1104 👎 0


import java.util.Arrays;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            if (set.contains(num)) {
//                return true;
//            }
//            set.add(num);
//        }
//        return false;
        // 	执行耗时:13 ms,击败了46.19% 的Java用户
        //	内存消耗:56.8 MB,击败了62.20% 的Java用户
        // 利用hashset写起来挺方便，但是效率似乎不是很高
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1;) {
            if (nums[i] == nums[++i]) {
                return true;
            }
        }
        return false;
        // 	执行耗时:19 ms,击败了36.23% 的Java用户
        //	内存消耗:53.8 MB,击败了89.07% 的Java用户
        // 受关联话题启发，试一试排序后判定
        // 偷个懒，利用arrays API排序，内存降了一点，但是速度并没有提升，在排序过程中其实可以提前判定结果，但改善效果应该不大
    }
}
//leetcode submit region end(Prohibit modification and deletion)
