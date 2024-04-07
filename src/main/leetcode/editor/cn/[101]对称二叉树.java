package main.leetcode.editor.cn;//给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,2,3,4,4,3]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,null,3,null,3]
//输出：false
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [1, 1000] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2684 👎 0

import main.customUtil.leetcode.TreeNode;

import java.util.LinkedList;

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        LinkedList<TreeNode> queueList = new LinkedList<>();
        queueList.offer(root.left);
        queueList.offer(root.right);
        TreeNode lNode;
        TreeNode rNode;
        while (!queueList.isEmpty()) {
            lNode = queueList.poll();
            rNode = queueList.poll();
            if (lNode == null ^ rNode == null) return false;
            if (lNode == null) continue;
            if (lNode.val != rNode.val) return false;
            queueList.offer(lNode.left);
            queueList.offer(rNode.right);
            queueList.offer(lNode.right);
            queueList.offer(rNode.left);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:40.7 MB,击败了68.94% 的Java用户
// 这个迭代的性能可以说是非常低了，还不如递归，按说不应该啊
//	执行耗时:1 ms,击败了18.44% 的Java用户
//	内存消耗:40.9 MB,击败了11.86% 的Java用户
// 队列宽搜
// 	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:40.7 MB,击败了71.50% 的Java用户
// 追求短代码可能造成效率降低
// 	执行耗时:1 ms,击败了18.41% 的Java用户
//	内存消耗:40.8 MB,击败了30.27% 的Java用户