package main.leetcode.editor.cn;//给定一个 无重复元素 的 有序 整数数组 nums 。

import java.util.LinkedList;
import java.util.List;
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 
//nums 的数字 x 。 
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出： 
//
// 
// "a->b" ，如果 a != b 
// "a" ，如果 a == b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 20 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中的所有值都 互不相同 
// nums 按升序排列 
// 
//
// Related Topics 数组 👍 415 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ansList = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return ansList;
        }
        int s = nums[0];
        int l = s;
        for (int i = 1; i < nums.length; i++) {
            if (++s != nums[i]) {
                if (l < (s - 1)) {
                    ansList.add(l + "->" + (s - 1));
                } else {
                    ansList.add(l + "");
                }
                l = s = nums[i];
            }
        }
        if (l < s) {
            ansList.add(l + "->" + (s));
        } else {
            ansList.add(l + "");
        }
        return ansList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 	执行耗时:8 ms,击败了9.34% 的Java用户
//	内存消耗:40.9 MB,击败了13.56% 的Java用户
// 看这个时间效率似乎不是很高，但是，这个时间复杂度似乎是O(n)的啊？

// 看提示里的数据范围，数据量不大，但是数值可能很大，但还是没发现有什么问题，看了几个题解分析，似乎没有看到什么更好很多的思路
