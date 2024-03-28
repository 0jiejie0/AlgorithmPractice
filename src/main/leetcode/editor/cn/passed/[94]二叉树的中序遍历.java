package main.leetcode.editor.cn;//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 2059 👎 0

import main.customUtil.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> ansList = new LinkedList<>();
        if (root == null) return ansList;
        if (root.left != null) {
            ansList.addAll(inorderTraversal(root.left));
        }
        ansList.add(root.val);
        if (root.right != null) {
            ansList.addAll(inorderTraversal(root.right));
        }
        return ansList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:40.7 MB,击败了43.39% 的Java用户