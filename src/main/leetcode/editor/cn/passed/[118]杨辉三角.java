package main.leetcode.editor.cn;//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
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
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
//
// Related Topics 数组 动态规划 👍 1146 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ansList = new LinkedList<>();
        List<Integer> lineList = new ArrayList<>();
        List<Integer> lastLine = lineList;
        lineList.add(1);
        ansList.add(lineList);
        if (numRows == 1) return ansList;
        for (int i = 2; i <= numRows; i++) {
            lineList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) lineList.add(1);
                else lineList.add(lastLine.get(j - 1) + lastLine.get(j));
            }
            ansList.add(lineList);
            lastLine = lineList;
        }
        return ansList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 	执行耗时:1 ms,击败了91.74% 的Java用户
//	内存消耗:41 MB,击败了69.06% 的Java用户