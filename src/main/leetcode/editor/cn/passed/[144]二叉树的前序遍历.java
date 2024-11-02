package main.leetcode.editor.cn;//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
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
// 示例 4： 
// 
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
// 
// 
//输入：root = [1,null,2]
//输出：[1,2]
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
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1240 👎 0

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
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> ansList = new LinkedList<>();
        LinkedList<TreeNode> treeNodeList = new LinkedList<>();
        TreeNode last = null;
        if (root == null) return ansList;
        ansList.add(root.val);
        treeNodeList.push(root);
        while (!treeNodeList.isEmpty()) {
            root = treeNodeList.peek();
            if (last != null) {
                if (last == root.left && root.right != null) {
                    last = null;
                    ansList.add(root.right.val);
                    treeNodeList.push(root.right);
                } else {
                    last = treeNodeList.pop();
                }
                continue;
            }
            if (root.left != null) {
                ansList.add(root.left.val);
                treeNodeList.push(root.left);
            } else if (root.right != null) {
                ansList.add(root.right.val);
                treeNodeList.push(root.right);
            } else {
                last = treeNodeList.pop();
            }
        }
        return ansList;
    }

//	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:40.7 MB,击败了56.79% 的Java用户

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        ArrayList<Integer> ansList = new ArrayList<>();
        if (null == root) {
            return ansList;
        }
        ansList.add(root.val);
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            root = nodeStack.peek();
            if (root.left != null) {
                ansList.add(root.left.val);
                nodeStack.push(root.left);
                root.left = null; // 断开已入栈的节点连接，防止重复
                continue;
            }
            if (root.right != null) {
                ansList.add(root.right.val);
                nodeStack.push(root.right);
                root.right = null;
                continue;
            }
            nodeStack.pop();
        }
        return ansList;
    }

// 	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:40.6 MB,击败了91.33% 的Java用户
// 和半年之前做的是两个思路，之前的思路是利用last指针记录上次遍历的结点，处理过程复杂一点，但是不会对原数据产生影响；
// 这次的思路是直接断开入栈节点的连接，过程更简单粗暴，但会打散原数据结构

// 这次虽然处理过程更简单，答题通过速度也更快，但是却忘了之前last指针的做法，看来还是得常刷，常做常新，今天的自己不一定就比昨天的自己更好，求学真的是逆水行舟啊
}
//leetcode submit region end(Prohibit modification and deletion)
