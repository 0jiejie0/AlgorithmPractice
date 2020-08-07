package main.problemAndSolving.leetcode_20200807;

import java.util.LinkedList;
import java.util.Queue;

//给定一个二叉树，检查它是否是镜像对称的。
//
//
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// 进阶：
//
// 你可以运用递归和迭代两种方法解决这个问题吗？
// Related Topics 树 深度优先搜索 广度优先搜索
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || judgeQueue(root.left, root.right);
    }

    /**
     * 发现昨天的queue对象创建出了问题，用时94m
     * 执行耗时:1 ms,击败了29.20% 的Java用户
     * 内存消耗:38 MB,击败了47.64% 的Java用户
     *
     * @param left
     * @param right
     * @return
     */
    private boolean judgeQueue(TreeNode left, TreeNode right) {
        Queue<TreeNode> lq = new LinkedList<>();
        Queue<TreeNode> rq = new LinkedList<>();
        TreeNode lp = left, rp = right;
        while (lp != null && rp != null) {
            if (lp.val != rp.val) {
                return false;
            }
            if (lp.left != null && rp.right != null) {
                lq.offer(lp.left);
                rq.offer(rp.right);
            } else if (lp.left != rp.right) {//这里在二者都为空时不能直接返回true（因为返回true会导致提前终止），区别于递归
                return false;
            }
            if (lp.right != null && rp.left != null) {
                lq.offer(lp.right);
                rq.offer(rp.left);
            } else if (lp.right != rp.left) {
                return false;
            }
            lp = lq.poll();
            rp = rq.poll();
        }
        return lp == rp && rq.isEmpty() && lq.isEmpty();
    }

    /**
     * 递归非常简单
     * 结点值漏判，两次通过
     * 用时13m
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.2 MB,击败了23.13% 的Java用户
     * 内存消耗的结果，让人失望
     *
     * @param left
     * @param right
     * @return
     */
    private boolean judgeRecursion(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            return left.val == right.val && judgeRecursion(left.left, right.right) && judgeRecursion(left.right, right.left);
        } else return left == right;
    }
}
