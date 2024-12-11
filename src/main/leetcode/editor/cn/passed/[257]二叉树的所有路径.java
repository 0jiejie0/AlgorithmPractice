package main.leetcode.editor.cn;//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//

import main.customUtil.AssertExample;
import main.customUtil.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 叶子节点 是指没有子节点的节点。 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 1178 👎 0


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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ansList = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode last = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left == null || node.right == null) {
                if (node.left == null && node.right == null) {
                    String s = "";
                    for (int i = stack.size() - 1; i >= 0; i--) {
                        s += stack.get(i).val;
                        if (i != 0) {
                            s += "->";
                        }
                    }
                    ansList.add(s);
                } else if (node.left != last && node.left != null && (node.right != last || node.right == null)) {
                    stack.push(node.left);
                    continue;
                } else if (node.right != last && node.right != null) {
                    stack.push(node.right);
                    continue;
                }
            } else if (node.left != last && node.right != last) {
                stack.push(node.left);
                continue;
            } else if (node.right != last) {
                stack.push(node.right);
                continue;
            }
            last = stack.pop();
        }
        return ansList;
    }
    // 这个效率之低，骇人听闻
    // 	执行耗时:9 ms,击败了11.21% 的Java用户
    //	内存消耗:42.3 MB,击败了5.14% 的Java用户
}
//leetcode submit region end(Prohibit modification and deletion)
