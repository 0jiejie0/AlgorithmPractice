package main.leetcode.editor.cn;
//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。如果存在，返回 true ；否则，返回 false 。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
//解释：等于目标和的根节点到叶节点路径如上图所示。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3], targetSum = 5
//输出：false
//解释：树中存在两条根节点到叶子节点的路径：
//(1 --> 2): 和为 3
//(1 --> 3): 和为 4
//不存在 sum = 5 的根节点到叶子节点的路径。 
//
// 示例 3： 
//
// 
//输入：root = [], targetSum = 0
//输出：false
//解释：由于树是空的，所以不存在根节点到叶子节点的路径。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1335 👎 0

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == targetSum;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        targetSum -= stack.peek().val;
        TreeNode last = null;
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (last != null) {
                if (last == root.left && root.right != null) {
                    last = null;
                    stack.push(root.right);
                    targetSum -= stack.peek().val;
                } else {
                    targetSum += stack.peek().val;
                    last = stack.pop();
                }
                continue;
            }
            if (root.left != null) {
                stack.push(root.left);
                targetSum -= stack.peek().val;
            } else if (root.right != null) {
                stack.push(root.right);
                targetSum -= stack.peek().val;
            } else {
                targetSum += stack.peek().val;
                last = stack.pop();
            }
        }
        return hasPathSum(root.left, targetSum -= root.val) || hasPathSum(root.right, targetSum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 数据规模不大，为什么还是占用了这么多空间呢？
// 	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:42.1 MB,击败了51.83% 的Java用户
// 看了官方题解，另有一种宽搜的解法，但是，宽搜的空间复杂度就更高了，如果手动压栈，相关的加减操作应该也是个不小的开销，但是可以节省空间。
// 果然，手动处理效率太低
// 	执行耗时:4 ms,击败了1.47% 的Java用户
//	内存消耗:43.3 MB,击败了6.60% 的Java用户