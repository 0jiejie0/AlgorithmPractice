package main.leetcode.editor.cn;//给定一个二叉树，判断它是否是 平衡二叉树
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1499 👎 0

import main.customUtil.leetcode.TreeNode;

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
    public boolean isBalanced(TreeNode root) {
        return deepth(root) >= 0;
    }

    /**
     * 求子树最大深度，子树高度差大于1返回-1表示不平衡，否则返回最大深度
     *
     * @param root
     * @return
     */
    public int deepth(TreeNode root) {
        if (root == null) return 0;
        int ld = deepth(root.left);
        int rd = deepth(root.right);
        if (ld == -1 || rd == -1) return -1;
        if (ld > rd)
            if (ld - rd > 1) return -1;
            else return ld + 1;
        if (ld < rd && rd - ld > 1) return -1;
        return rd + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:43.1 MB,击败了92.98% 的Java用户