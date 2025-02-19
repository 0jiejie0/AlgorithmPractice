package main.leetcode.editor.cn;//给你一棵二叉树的根节点，返回该树的 直径 。

import main.customUtil.leetcode.TreeNode;
//
// 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。 
//
// 两节点之间路径的 长度 由它们之间边数表示。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5]
//输出：3
//解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1658 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        deep(root);
        return max;
    }

    private int deep(TreeNode node) {
        if (node.left == null) {
            if (node.right == null) {
                return 0;
            } else {
                int d = deep(node.right) + 1;
                if (d > max) {
                    max = d;
                }
                return d;
            }
        } else {
            if (node.right == null) {
                int d = deep(node.left) + 1;
                if (d > max) {
                    max = d;
                }
                return d;
            } else {
                int l = deep(node.left);
                int r = deep(node.right);
                if (max < (l + r + 2)) { // 左右子树同时存在，从左右最近节点穿越本节点的长度 和 历史最大长度 需要比较
                    max = (l + r + 2);
                }
                return l < r ? r + 1 : l + 1;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 解答成功:
//	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:43.8 MB,击败了61.29% 的Java用户
