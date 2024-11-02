package main.leetcode.editor.cn;//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
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
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1168 👎 0

import main.customUtil.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ansList = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) return ansList;
        TreeNode last = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (last != null) {
                if (last == root.left && root.right != null) {
                    last = null;
                    stack.push(root.right);
                } else {
                    last = stack.pop();
                    ansList.add(last.val);
                }
                continue;
            }
            if (root.left != null) stack.push(root.left);
            else if (root.right != null) stack.push(root.right);
            else {
                last = stack.pop();
                ansList.add(last.val);
            }
        }
        return ansList;
    }
// 和上一题的先序遍历差不多，不同的是把入栈输出改为了出栈输出
// 	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:40.5 MB,击败了90.43% 的Java用户


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        if (root == null) {
            return ansList;
        }
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            root = nodeStack.peek();
            if (root.left != null) {
                nodeStack.push(root.left);
                root.left = null;
                continue;
            }
            if (root.right != null) {
                nodeStack.push(root.right);
                root.right = null;
                continue;
            }
            ansList.add(root.val);
            nodeStack.pop();
        }
        return ansList;
    }
// 	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:40.6 MB,击败了76.63% 的Java用户
// 简单粗暴地写确实更快
}
//leetcode submit region end(Prohibit modification and deletion)