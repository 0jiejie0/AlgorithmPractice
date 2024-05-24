package main.leetcode.editor.cn;//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
//
// Related Topics 数组 动态规划 👍 539 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ansList = new ArrayList<>(rowIndex);
        ansList.add(1);
        if (rowIndex++ == 0) return ansList;
        while (ansList.size() < rowIndex) {
            for (int i = (ansList.size() >> 1); i > 0; i--) {
                ansList.set(i, ansList.get(i - 1) + ansList.get(i));
            }
            for (int i = (ansList.size() >> 1) + 1; i < ansList.size(); i++) {
                ansList.set(i, ansList.get(ansList.size() - i));
            }
            ansList.add(1);
        }
        return ansList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 没看清题意，题目说的是 O(rowIndex) 空间复杂度，我当成时间复杂度了，推了很久公式，还心想这32 n个几次方也不能超时啊，为啥要求是线性复杂度呢
// 浪费太多时间和精力了，不应该出现这种情况的。
// 	执行耗时:1 ms,击败了77.51% 的Java用户
//	内存消耗:40.1 MB,击败了85.54% 的Java用户