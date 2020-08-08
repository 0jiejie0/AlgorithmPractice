package main.problemAndSolving.leetcode_20200808;
//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索
//这个很简单，深搜瞬间完成，但是由于创建文件，总完成时间不理想（算是一个理由？？）用时6m49s
//执行耗时:0 ms,击败了100.00% 的Java用户
//		内存消耗:40.1 MB,击败了5.21% 的Java用户

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == root.right) {//左右子树都为null
            return 1;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return (l > r ? l : r) + 1;
    }
}
