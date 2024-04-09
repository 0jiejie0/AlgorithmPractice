package main.leetcode.editor.cn;//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1176 👎 0

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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(null);
        queue.offer(root);
        while (!queue.isEmpty()) {
            if ((root = queue.poll()) == null) {
                queue.offer(root);
                ans++;
                continue;
            }
            if (root.left == null && root.right == null) {
                return ans;
            }
            if (root.left != null) queue.offer(root.left);
            if (root.right != null) queue.offer(root.right);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 这递归速度有点慢，就算比最大深度复杂一点，数据规模大一点，耗时排名也不能这么低啊
// 	执行耗时:8 ms,击败了61.08% 的Java用户
//	内存消耗:61.3 MB,击败了93.80% 的Java用户
// 看了官方题解，换成宽搜，果然速度提高了，不过内存消耗也上去了，队列是挺消耗内存
// 	执行耗时:2 ms,击败了96.24% 的Java用户
//	内存消耗:61.6 MB,击败了70.69% 的Java用户