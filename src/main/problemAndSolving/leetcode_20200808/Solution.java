package main.problemAndSolving.leetcode_20200808;
//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索
//这个很简单，深搜瞬间完成，但是由于创建文件，总完成时间不理想（算是一个理由？？）用时6m49s
//执行耗时:0 ms,击败了100.00% 的Java用户
//		内存消耗:40.1 MB,击败了5.21% 的Java用户

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == root.right) {//左右子树都为null
            return 1;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return (l > r ? l : r) + 1;
    }

    //给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其自底向上的层次遍历为：
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
//
// Related Topics 树 广度优先搜索
// 太久没用栈和队列，相关类型API用不顺手，消耗一些时间，用时30m
// 执行耗时:1 ms,击败了97.98% 的Java用户
//		内存消耗:40.2 MB,击败了15.47% 的Java用户
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> resS = new Stack<>();
        List<Integer> list;
        Queue<TreeNode> queueOdd = new LinkedList<>();
        Queue<TreeNode> queueTemp = new LinkedList<>();
        TreeNode node;
        if (root != null) {
            ((LinkedList<TreeNode>) queueOdd).add(root);
        }
        while (!queueOdd.isEmpty()) {
            list = new LinkedList<>();
            while (!queueOdd.isEmpty()) {
                node = queueOdd.poll();
                list.add(node.val);
                if (node.left != null) {
                    ((LinkedList<TreeNode>) queueTemp).add(node.left);
                }
                if (node.right != null) {
                    ((LinkedList<TreeNode>) queueTemp).add(node.right);
                }
            }
            resS.push(list);
            Queue<TreeNode> queue = queueOdd;
            queueOdd = queueTemp;
            queueTemp = queue;
        }
        List<List<Integer>> resL = new LinkedList<>();
        while (!resS.isEmpty()) {
            resL.add(resS.pop());
        }
        return resL;
    }
}
