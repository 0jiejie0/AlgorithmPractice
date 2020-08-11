package main.problemAndSolving.leetcode_20200811;

//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
//
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
// Related Topics 树 深度优先搜索
// 本来不想用深搜，感觉效率不高，但是又想不出什么高效的方法，看了一下标签写的深搜，算了还是深搜吧，用时28m
// 执行耗时:0 ms,击败了100.00% 的Java用户
//		内存消耗:40 MB,击败了7.65% 的Java用户
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        return root.left == root.right && sum == 0 || hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,1]
//输出: 1
//
//
// 示例 2:
//
// 输入: [4,1,2,1,2]
//输出: 4
// Related Topics 位运算 哈希表
// 对蓝桥讲的内容有些印象，同数一次异或运算结果为0，耗时1m47s
// 执行耗时:1 ms,击败了99.67% 的Java用户
//		内存消耗:40.7 MB,击败了74.62% 的Java用户
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
