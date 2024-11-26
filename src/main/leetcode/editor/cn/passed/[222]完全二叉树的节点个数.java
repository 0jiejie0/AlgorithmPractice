package main.leetcode.editor.cn;
import main.customUtil.leetcode.TreeNode;
//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层，则该层包含 1~ 2ʰ 个节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 10⁴] 
// 0 <= Node.val <= 5 * 10⁴ 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
//
// Related Topics 位运算 树 二分查找 二叉树 👍 1197 👎 0


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
    public int countNodes(TreeNode root) {
        // 题目末尾要求用比O（n）更快的方案，这个得想一下
        // 左右两端到叶子的路径长度量一下，一样就直接算出来，不一样就分别左右子树，然后加上根节点
        // 这样应该是log n 的复杂度，不能再降了吧？
        if (root == null) {
            return 0;
        } else if (root.right == null || root.left == null) {
            if (root.left == null && root.right == null) {
                return 1;
            }
            if (root.left == null) {
                return 1 + countNodes(root.right);
            }
            return 1 + countNodes(root.left);
        }
        TreeNode node = root.left;
        int l = 0, r = 0;
        while (node != null) {
            l++;
            node = node.left;
        }
        while (node != null) {
            r++;
            node = node.right;
        }
        if (l == r) {
            l++;
            return (1 << l) - 1;
        }
        return countNodes(root.left) + 1 + countNodes(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:46.8 MB,击败了5.01% 的Java用户
// 速度还行，但是内存有这么夸张吗？