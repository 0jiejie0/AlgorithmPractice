package main.problemAndSolving.leetcode.leetcode_20200813;

import java.util.LinkedList;
import java.util.List;

//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
//
//
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。
//
// 示例:
//
// 输入: 3
//输出: [1,3,3,1]
//
//
// 进阶：
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？
// Related Topics 数组 规律不难找，下标计算翻过来调过去绕了好几个弯，用时29m
// 执行耗时:0 ms,击败了100.00% 的Java用户
//		内存消耗:37.3 MB,击败了46.21% 的Java用户
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new LinkedList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            if (i <= (rowIndex >> 1)) {
                res.add((int) ((long) res.get(i - 1) * (rowIndex - i + 1) / i));
            } else {
                res.add(res.get(rowIndex - i));
            }
        }
        return res;
    }
}
