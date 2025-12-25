//给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 1008 👎 0


import java.util.Arrays;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        int n = 0;
        int[] ans;
        if (nums1.length < nums2.length) {
            ans = nums1;
            nums1 = nums2;
            nums2 = ans;
        }
        ans = new int[nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            int j = nums2[i];
            if (set.contains(j)) {
                set.remove(j);
                ans[n++] = j;
            }
        }
        return Arrays.copyOf(ans, n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 	执行耗时:2 ms,击败了90.24% 的Java用户
//	内存消耗:44 MB,击败了49.28% 的Java用户
// 如果用集合，效率不见得会更高
// 	执行耗时:3 ms,击败了60.70% 的Java用户
//	内存消耗:44.4 MB,击败了13.64% 的Java用户
// 果然效率不高